package com.data.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.data.base.DatabaseConnection;

public class DBHelper extends DatabaseConnection {
	Connection _CONN = null;

	private String sDBUrl;
	private String sDriverName;
	private String sUser;
	private String sPwd;
	private String databaseName;

	public DBHelper(String sDBUrl, String sDriverName, String sUser, String sPwd, String databaseName) {
		setsDBUrl(sDBUrl);
		setsDriverName(sDriverName);
		setsUser(sUser);
		setsPwd(sPwd);
		setDatabaseName(databaseName);
	}

	// 获得数据库连接
	private boolean GetConn(String sUser, String sPwd) {
		if (_CONN != null)
			return true;
		try {

			String sDriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			// String sDBUrl
			// ="jdbc:sqlserver://192.168.0.74;databaseName=wakeup";
			// String sDBUrl =
			// "jdbc:sqlserver://192.168.2.28\\JONSE;databaseName=wakeup";
			// String sDBUrl = "
			// jdbc:sqlserver://localhost:1434;databaseName=PropertyManager";
			String sDBUrl = "jdbc:sqlserver://127.0.0.1:1434;databaseName=PropertyManager";
			Class.forName(sDriverName);

			_CONN = DriverManager.getConnection(sDBUrl, sUser, sPwd);
		} catch (Exception ex) {
			ex.printStackTrace();

			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * 调用生成数据库连接
	 * 
	 * @return
	 */
	public Connection GetConn() {
		_CONN = super.getConnection(sDriverName, sDBUrl, sUser, sPwd);
		return _CONN;
	}

	// 关闭数据库的连接
	public void CloseConn() {
		super.closeConection(_CONN);
	}

	/**
	 * prepareStatement 执行sql语句返回Resultset对象 支持预编译
	 * 
	 * @param sSQL
	 * @param objParams
	 * @return
	 */
	public ResultSet GetResultSet(String sSQL, Object[] objParams) {
		GetConn();
		ResultSet rs = null;
		try {
			PreparedStatement ps = _CONN.prepareStatement(sSQL);
			if (objParams != null) {
				for (int i = 0; i < objParams.length; i++) {
					ps.setObject(i + 1, objParams[i]);
				}
			}
			rs = ps.executeQuery();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			CloseConn();
		} finally {
			// CloseConn();
		}
		return rs;
	}

	/**
	 * prepareStatement 获得单个值
	 * 
	 * @param sSQL
	 * @param objParams
	 * @return
	 */
	public Object GetSingle(String sSQL, Object... objParams) {
		GetConn();
		try {
			PreparedStatement ps = _CONN.prepareStatement(sSQL);
			if (objParams != null) {
				for (int i = 0; i < objParams.length; i++) {
					ps.setObject(i + 1, objParams[i]);
				}
			}
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getString(1);// 适合查询的count
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			CloseConn();
		}
		return null;
	}

	/**
	 * prepareStatement 获得 DateTable数据集
	 * 
	 * @param sSQL
	 * @param objParams
	 * @return
	 */
	public DataTable GetDataTable(String sSQL, Object... objParams) {
		GetConn();
		DataTable dt = null;
		try {
			PreparedStatement ps = _CONN.prepareStatement(sSQL);
			if (objParams != null) {
				for (int i = 0; i < objParams.length; i++) {
					ps.setObject(i + 1, objParams[i]);
				}
			}
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			List<DataRow> row = new ArrayList<DataRow>(); // 定义DataRow 的list集合
			List<DataColumn> col = null; // 定义column对象集合
			DataRow r = null;// 行
			DataColumn c = null;// 的列

			String columnName;
			Object value;
			int iRowCount = 0;
			while (rs.next())// 循环遍历
			{
				iRowCount++;
				col = new ArrayList<DataColumn>();// 创建column对象集合
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					columnName = rsmd.getColumnName(i);
					value = rs.getObject(columnName);
					c = new DataColumn(columnName, value);// 创建column对象
					col.add(c); // 把对象添加到集合中
				}
				r = new DataRow(col);// 创建dataRow对象 把column集合作为初始化参数
				row.add(r);// 添加到dataRow集合当中
			}
			dt = new DataTable(row);
			dt.RowCount = iRowCount;
			dt.ColumnCount = rsmd.getColumnCount();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			CloseConn();
		}
		return dt;
	}

	/**
	 * prepareStatement 执行更新 删除
	 * 
	 * @param sSQL
	 * @param objParams
	 * @return
	 */
	public int UpdateData(String sSQL, Object[] objParams) {
		GetConn();
		int iResult = 0;

		try {
			PreparedStatement ps = _CONN.prepareStatement(sSQL);
			if (objParams != null) {
				for (int i = 0; i < objParams.length; i++) {
					ps.setObject(i + 1, objParams[i]);
				}
			}
			iResult = ps.executeUpdate(sSQL);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return -1;
		} finally {
			CloseConn();
		}
		return iResult;
	}

	public String getsDBUrl() {
		return sDBUrl;
	}

	public void setsDBUrl(String sDBUrl) {
		this.sDBUrl = sDBUrl;
	}

	public String getsDriverName() {
		return sDriverName;
	}

	public void setsDriverName(String sDriverName) {
		this.sDriverName = sDriverName;
	}

	public String getsUser() {
		return sUser;
	}

	public void setsUser(String sUser) {
		this.sUser = sUser;
	}

	public String getsPwd() {
		return sPwd;
	}

	public void setsPwd(String sPwd) {
		this.sPwd = sPwd;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

}
