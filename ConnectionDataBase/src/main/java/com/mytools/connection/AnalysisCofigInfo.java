package com.mytools.connection;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * 解析配置文件
 * @author li
 *
 */
public class AnalysisCofigInfo {

	/**
	 * mysql获取数据库中所有表的名字的sql、语句
	 */
	private static final String MYSQLGETTABLESQL = "MYSQLGETTABLESQL";
	/**
	 * mysql获取表中的字段的名字及数据类型 sql、语句
	 */
	private static final String MYSQLGETTABLECOLUMNSQL = "MYSQLGETTABLECOLUMNSQL ";
	/**
	 * sqlserver获得数据库中说有表的名字sql、语句
	 */
	private static final String SQLSERVERGETTABLESQL = "SQLSERVERGETTABLESQL";
	/**
	 * sqlserver获取表中字段 sql、语句
	 */
	private static final String SQLSERVERGETTABLCOLUMESQL = "SQLSERVERGETTABLCOLUMESQL";
     /**
      * 获取表中的主键字段名称
      */
	private static final String SQLSERVERTABLEPRIMARYKEY = "SQLSERVERTABLEPRIMARYKEY";
    /**
     * oracle 获得表的sql语句
     */
	private static final String ORACLEGETTABLESQL = "ORACLEGETTABLESQL";
    /**
     * oracle 获得表中的列的名字
     */
	private static final String ORACLEGETTABLECOLUMESQL = "ORACLEGETTABLECOLUMESQL";
	public static final String DRIVERCLASSNAME = "DRIVERCLASSNAME";
	public static final String URL = "URL";
	public static final String USERNAME = "USERNAME";
	public static final String PASSWORD = "PASSWORD";
	public static final String DATABASENAME = "DATABASENAME";
	/**
	 * sqlserver对应的数据类型的java类型
	 */
	private static Map<String, String> dataConfig;
	/**
	 * 枚举类型 判断是哪个数据库
	 */
	private static SqlService sqlService = SqlService.MYSQL;
    /**
     * 构造函数  选择哪种数据库
     * @param sqlService 
     */
	AnalysisCofigInfo(SqlService sqlService) {
		this.sqlService = sqlService;
		try {
			/**
			 * 填充数据到dataConfig
			 */
			dataConfig = FillConfig.fillTypes(sqlService, "com.mytools.database.config.database");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据不同的数据库中的数据类型获得对应的java数据类型
	 * 
	 * @param type
	 * @return
	 */
	public String getJavaType(String datatype, StringBuffer importStr) {
		String javaDatatype = "";
		System.out.println(dataConfig);
		javaDatatype = getDataConfigValue(datatype);
		if (isNUll(javaDatatype) || !javaDatatype.contains(".")) {
			return null;
		}
		if (!javaDatatype.contains("java.lang.")) {
			if (importStr.toString().contains(javaDatatype)) {
			} else
				importStr.append("\r\n" + javaDatatype + ";");
		}
		return javaDatatype.substring(javaDatatype.lastIndexOf(".") + 1, javaDatatype.length());
	}
	/**
	 * 获得配置文件中的获得列的sql语句并进行替换
	 * 
	 * @param name
	 * @return
	 */
	public String getTableColumnSql(String name) {

		Map<String, String> replaceMap = new HashMap<>();
		replaceMap.put("tableName", name);
		String tableColumnSql = "";
		switch (sqlService) {
		case SQLSERVER:
			tableColumnSql = getSql(SQLSERVERGETTABLCOLUMESQL, replaceMap);
			break;
		case MYSQL:
			tableColumnSql = getSql(MYSQLGETTABLECOLUMNSQL, replaceMap);
			break;
		case ORACLE:
			tableColumnSql = getSql(ORACLEGETTABLECOLUMESQL, replaceMap);
			;
			break;
		}
		return tableColumnSql;
	}
    /**
     * 获得table 的主键  现在这个版本只有sqlserver的获得主键的sql语句
     * @param tableName
     * @return
     */
	public String getTablePrimaryKeySql(String tableName) {

		Map<String, String> replaceMap = new HashMap<>();
		replaceMap.put("tableName", tableName);
		String tablePrimaryKeySql = "";
		switch (sqlService) {
		case SQLSERVER:
			tablePrimaryKeySql = getSql(SQLSERVERTABLEPRIMARYKEY, replaceMap);
			break;
		case MYSQL:
			// tableColumnSql = getSql(MYSQLGETTABLECOLUMNSQL,replaceMap);
			break;
		case ORACLE:
			// tableColumnSql = getSql(ORACLEGETTABLECOLUMESQL,replaceMap);;
			break;
		}
		return tablePrimaryKeySql;
	}

	/**
	 * 重新封装一次 dataConfig的get方法
	 * @param key
	 * @return
	 */
	public String getDataConfigValue(String key) {
		return dataConfig.get(key.trim().toUpperCase());
	}

	/**
	 * 获得配置文件中的 获得表名称的sql语句
	 * @return
	 */
	public String getTableSql() {
		Map<String, String> replaceMap = new HashMap<>();
		replaceMap.put("databaseName", getDataConfigValue(DATABASENAME));
		String tableSql = "";
		switch (sqlService) {
		case SQLSERVER:
			tableSql = getSql(SQLSERVERGETTABLESQL, replaceMap);
			break;
		case MYSQL:
			tableSql = getSql(MYSQLGETTABLESQL, replaceMap);
			break;
		case ORACLE:
			tableSql = getSql(ORACLEGETTABLESQL, replaceMap);
			break;
		}
		return tableSql;
	}

	/**
	 * 不对外提供的私有方法 进行解析sql语句 进行字段的替换
	 * @param key   配置文件key
	 * @param replaceMap 被替换的key和数据
	 * @return
	 */
	private String getSql(String key, Map<String, String> replaceMap) {
		String sql = getDataConfigValue(key);
		if (isNUll(sql))
			return "";
		Set entrySet = replaceMap.entrySet();
		for (Map.Entry entry : replaceMap.entrySet()) {

			if (sql.contains("#{" + entry.getKey().toString().trim() + "}")) {
				sql = sql.replace("#{" + entry.getKey().toString() + "}", (String) entry.getValue());
			}
		}
		return sql;
	}

	public boolean isNUll(Object o) {
		return null == o || "".equals(o) ? true : false;
	}

	public SqlService getSqlService() {
		return sqlService;
	}

}
