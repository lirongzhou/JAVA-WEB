package com.data.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	private static ResultSet rs = null;

	private static Statement stmt = null;

	private static Connection conn;

	/**
	 * 创建一个连接
	 * 
	 * @param className
	 * @param jdbcUrl
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void createConnection(String className, String jdbcUrl, String sUser, String sPwd)
			throws ClassNotFoundException, SQLException {

		Class.forName(className);

		conn = DriverManager.getConnection(jdbcUrl, sUser, sPwd);

	}

	/**
	 * 对外调用获得一个连接
	 * 
	 * @param className
	 * @param jdbcUrl
	 * @return
	 */
	public Connection getConnection(String className, String jdbcUrl, String sUser, String sPwd) {
		if (conn == null) {
			try {
				createConnection(className, jdbcUrl, sUser, sPwd);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}

	/**
	 * 关闭连接
	 * 
	 * @param conn
	 */
	public void closeConection(Connection conn) {
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			conn = null;
			e.printStackTrace();
		}
	}

	/**
	 * 获得Statement对象 这个对象不支持预编译
	 * 
	 * @param conn
	 * @return
	 */
	@SuppressWarnings("finally")
	public Statement getStatement(Connection conn) {
		try {

			if (stmt == null) {
				stmt = conn.createStatement();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return stmt;
		}
	}

	/**
	 * Statement 执行sql 返回Boolean值
	 * 
	 * @param stmt
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("finally")
	public boolean executeUpdate(Statement stmt, String sql) {
		int result = -1;
		try {
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return result != -1 ? true : false;
		}

	}

	/**
	 * Statement 执行sql 返回ResultSet对象
	 * 
	 * @param stmt
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("finally")
	public ResultSet executeQuery(Statement stmt, String sql) {

		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			return rs;
		}

	}

	/**
	 * 解析 ResultSet 数据获得一个对象集合
	 * 
	 * @param rs
	 * @param cs
	 * @return
	 */
	// @SuppressWarnings({ "finally", "unchecked", "rawtypes" })
	// public List analysis(ResultSet rs, Class cs) {
	// Reflection reflection = new Reflection();
	// String cols_name;
	// List<Map> mapList = new ArrayList();
	// List list = new ArrayList();
	// Map map;
	// try {
	// java.sql.ResultSetMetaData md = rs.getMetaData();
	// while (rs.next()) {
	// map = new HashMap();
	// for (int i = 0; i < md.getColumnCount(); i++) {
	//
	// cols_name = md.getColumnName(i + 1);
	// Object val = rs.getObject(cols_name);
	//
	// map.put(cols_name, val);
	//
	// val = (val == null) ? "" : val;
	// }
	// mapList.add(map);
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	//
	// }
	// try {
	// for (Map m : mapList) {
	// list.add(reflection.assignment(cs, m));
	// }
	//
	// } catch (NoSuchMethodException | SecurityException |
	// InstantiationException | IllegalAccessException
	// | IllegalArgumentException | InvocationTargetException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	//
	// } finally {
	// return list;
	// }
	//
	// }

	/**
	 * 
	 * @param lineTypes
	 *            连接类型 and 或者 or
	 * @param Column
	 *            数据库中的字段
	 * @param way
	 *            执行方式
	 * @param values
	 *            条件的值
	 * @return
	 */
	public String whereSqlCombination(String[] lineTypes, String[] Column, String[] way, String[] values) {

		StringBuffer sqlWhere = new StringBuffer(" where 1=1 ");
		String empty = " ";
		for (int i = 0; i < lineTypes.length; i++) {
			sqlWhere.append(empty + lineTypes[i] + Column[i] + way[i] + "'" + values + "'");
		}
		return sqlWhere.toString();
	}

}
