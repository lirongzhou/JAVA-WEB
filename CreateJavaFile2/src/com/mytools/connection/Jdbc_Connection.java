package com.mytools.connection;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.data.base.DBHelper;
import com.java.templet.JavaFileTempletBase;

public class Jdbc_Connection extends DBHelper {

	public Jdbc_Connection(String sDBUrl, String sDriverName, String sUser, String sPwd, String databaseName) {
		super(sDBUrl, sDriverName, sUser, sPwd, databaseName);
	}

	/**
	 * java文件生成模板
	 */
	JavaFileTempletBase javaFileTempletBase;

	private String implBaseSuffix;

	public String getImplBaseSuffix() {
		return implBaseSuffix;
	}

	public void setImplBaseSuffix(String implBaseSuffix) {
		this.implBaseSuffix = implBaseSuffix;
	}

	public void setJavaFileTempletBase(JavaFileTempletBase javaFileTempletBase) {
		this.javaFileTempletBase = javaFileTempletBase;
	}

	private boolean isEntity = false;

	public boolean isEntity() {
		return isEntity;
	}

	public void setEntity(boolean isEntity) {
		this.isEntity = isEntity;
	}

	/**
	 * 在sqlserver数据库中得到表的所有的名字
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<String> GetTableNames(String sql) throws SQLException {
		ResultSet rs = super.GetResultSet(sql, null);
		java.sql.ResultSetMetaData md = rs.getMetaData();
		List<String> list = new ArrayList<String>();
		while (rs.next()) {
			list.add(rs.getString(1));
		}
		return list;
	}

	/**
	 * 在sqlserver数据库中得到表的所有的名字
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String GetTablePrimaryKey(String sql) throws SQLException {
		ResultSet rs = super.GetResultSet(sql, null);
		java.sql.ResultSetMetaData md = rs.getMetaData();
		String primaryKey = "";
		while (rs.next()) {
			primaryKey = rs.getString("COLUMN_NAME");
			return primaryKey;
		}
		return primaryKey;
	}

	/**
	 * 获得表中的字段 数据类型 转换成为java的数据类型
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public ResultSet GetTableColumnNames(String sql) throws SQLException {
		ResultSet rs = super.GetResultSet(sql, null);
		return rs;
	}

	public boolean isNUll(Object o) {

		return null == o || "".equals(o) ? true : false;
	}

}
