package com.mytools.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.mytools.config.PropertiesOperation;
import com.mytools.connection.SqlService;

public class Test {

	private static String sysPath = System.getProperty("user.dir");

	/**
	 * 枚举类型 判断是哪个数据库
	 */
	private static SqlService sqlService = SqlService.SQLSERVER;
	/**
	 * sqlserver对应的数据类型的java类型
	 */
	private static Map<String, String> javaAndSqlserverDataTypes = new HashMap<String, String>();
	/**
	 * mysql对应的数据类型的java类型
	 */
	private static Map<String, String> javaAndMysqlDataTypes = new HashMap<String, String>();
	/**
	 * oracle对应的数据类型的java类型
	 */
	private static Map<String, String> javaAndOraclelDataTypes = new HashMap<String, String>();

	public static void main(String[] args) throws IOException {

		//
		// // TODO Auto-generated method stub
		// PropertiesOperation propertiesOperation = new PropertiesOperation();
		// String strPackage =
		// "com.mytools.java_types_or_database_types.config";
		// strPackage = strPackage.replaceAll("\\.", "/");
		//
		//
		// Properties properties = propertiesOperation.load(sysPath + "/src/" +
		// strPackage + "//datatypes.properties");
		//
		// Set set=properties.keySet();
		// Iterator iterator= set.iterator();
		// while(iterator.hasNext()){
		// String key=iterator.next().toString();
		// String subKey=key.substring(key.lastIndexOf("_")+1, key.length());
		//
		// switch(sqlService){
		// case SQLSERVER:
		// if(key.contains("sqlserver")){
		// javaAndSqlserverDataTypes.put(subKey.toUpperCase(),
		// properties.getProperty(key));
		// }
		// break;
		// case MYSQL:
		// if(key.contains("mysql")){
		// javaAndMysqlDataTypes.put(subKey.toUpperCase(),
		// properties.getProperty(key));
		// }
		// break;
		//
		// case ORACLE:
		// if(key.contains("oracle")){
		// javaAndOraclelDataTypes.put(subKey.toUpperCase(),
		// properties.getProperty(key));
		// }
		// break;
		// }
		// }
	}

	//
	// public MantotoProperties(){
	// try {
	// pps.load(new InputStreamReader(new
	// FileInputStream(sysPath+"//src//com//mantoto//config//message//"+"mantoto.properties"),"UTF-8"));
	// } catch (FileNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

}
