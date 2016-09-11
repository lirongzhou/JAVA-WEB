package com.mytools.connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import com.java.templet.FileMapperXmlTemplet;
//import com.java.templet.JavaBeanFileTemplet;
//import com.java.templet.JavaContorllerIterfaceTemplet;
//import com.java.templet.JavaFileTempletBase;
//import com.java.templet.JavaIterfaceCacheImplTemplate;
//import com.java.templet.JavaIterfaceCacheTemplet;
//import com.java.templet.JavaIterfaceImplContorllerTemplate;
//import com.java.templet.JavaIterfaceServiceCacheImplTemplate;
//import com.java.templet.JavaIterfaceServiceImplTemplate;
//import com.java.templet.JavaIterfaceServiceTemplet;
//import com.java.templet.JavaIterfaceTemplet;
//import com.java.templet.JavaJunitSpringTestTemplet;
import com.mantoto.util.FindClasses;

public class CreateJavaFile {

	AnalysisCofigInfo analysisCofigInfo = new AnalysisCofigInfo(SqlService.SQLSERVER);
	Jdbc_Connection Jdbc_Connection = new Jdbc_Connection(analysisCofigInfo.getDataConfigValue(AnalysisCofigInfo.URL),
			analysisCofigInfo.getDataConfigValue(AnalysisCofigInfo.DRIVERCLASSNAME),
			analysisCofigInfo.getDataConfigValue(AnalysisCofigInfo.USERNAME),
			analysisCofigInfo.getDataConfigValue(AnalysisCofigInfo.PASSWORD),
			analysisCofigInfo.getDataConfigValue(AnalysisCofigInfo.DATABASENAME));

//	JavaFileTempletBase JavaFileTemple = new JavaBeanFileTemplet();
//	/**
//	 * 需要导入包的集合
//	 */
//	private StringBuffer importStr = new StringBuffer();
//	List<String> tableNames;

	private Map<String, String> analysisDataType(ResultSet rs,StringBuffer importStr) throws SQLException {
		Map<String, String> map = new HashMap<String, String>();
		String type;
		String typeValue;
		while (rs.next()) {
			typeValue = "";
			type = rs.getString(2);
			typeValue = analysisCofigInfo.getJavaType(type, importStr);
			if (null != typeValue) {
				if (isNull(rs.getString("ColumnDescription"))) {
					map.put(rs.getString(1), typeValue);
				} else {
					/**
					 * 
					 */
					String fieldName=""
							+ "\n/**"
							+ "\n*"+rs.getString("ColumnDescription")
							+ "\n*/\n"+typeValue;
					map.put(rs.getString(1), fieldName);
				}

			} else {
				System.out.println("sorry   没有找到对应的数据类型" + type);
			}

		}

		rs.close();
		return map;
	}

	public boolean isNull(Object o) {

		return null == o || "".equals(o) ? true : false;
	}

	public List<String> getTableNames() throws SQLException{
		return Jdbc_Connection.GetTableNames(analysisCofigInfo.getTableSql());
	}
	
	public Map<String, String> getJavaFields(String tableName,StringBuffer importStr) throws SQLException{
		return analysisDataType(
				Jdbc_Connection.GetTableColumnNames(analysisCofigInfo.getTableColumnSql(tableName)),importStr);
	}
	
	public String  getPrimaryKey(String tableName) throws SQLException{
		 return Jdbc_Connection.GetTablePrimaryKey(analysisCofigInfo.getTablePrimaryKeySql(tableName));
	}
	/**
	 * 生成实体类
	 * 
	 * @param packageStr
	 */
//	public void createJavaEntity(String packageStr, String importStr) {
//		JavaFileTemple = new JavaBeanFileTemplet();
//
//		try {
//			tableNames = Jdbc_Connection.GetTableNames(analysisCofigInfo.getTableSql());
//
//			/**
//			 * 获得数据库中的字段
//			 */
//			for (String item : tableNames) {
//				Map<String, String> fields = analysisDataType(
//						Jdbc_Connection.GetTableColumnNames(analysisCofigInfo.getTableColumnSql(item)));
//				String primaryKey = Jdbc_Connection.GetTablePrimaryKey(analysisCofigInfo.getTablePrimaryKeySql(item));
//				JavaFileTemple.setPrimaryKey(

//				JavaFileTemple.analysisDataConntent(packageStr, this.importStr.toString() + importStr, item, fields);
//			}
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}

	/**
	 * 生成接口
	 * 
	 * @param packageStr
	 * @param beanPackage
	 */
//	public void createJavaInterface(String packageStr, String beanPackage, String Suffix, String prefix) {
//		JavaFileTemple = new JavaIterfaceTemplet();
//		JavaFileTemple.setPrefix(prefix);
//		JavaFileTemple.setSuffix(Suffix);
//		try {
//			if (null == tableNames) {
//				tableNames = Jdbc_Connection.GetTableNames(analysisCofigInfo.getTableSql());
//			}

			// test.setEntity(false);
			// test.setJavaFileTempletBase("com.java.templet.JavaIterfaceTemplet","Dao");
			// test.javaFileTempletBase.setPrefix("I");
			// test.CreateJavaMaim("com.matoto.dao.message",
			// test.getTableSql(),"import com.matoto.bean.message","import
			// java.util.List;\r\n");

//			for (String item : tableNames) {
//				importStr = new StringBuffer();
//				importStr.append("import java.util.List;\r\n");
//				importStr.append("import " + beanPackage + "." + item + ";\r\n");
//				JavaFileTemple.analysisDataConntent(packageStr, importStr.toString(), item, beanPackage, null);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	/**
	 * 生成接口
	 * 
	 * @param packageStr
	 * @param beanPackage
	 */
//	public void createJavaServiceInterface(String packageStr, String beanPackage, String Suffix, String prefix) {
//		JavaFileTemple = new JavaIterfaceServiceTemplet();
//		JavaFileTemple.setPrefix(prefix);
//		JavaFileTemple.setSuffix(Suffix);
//		try {
//			if (null == tableNames) {
//				tableNames = Jdbc_Connection.GetTableNames(analysisCofigInfo.getTableSql());
//			}
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("boolean", "isContorller");
//			for (String item : tableNames) {
//				importStr = new StringBuffer();
//				importStr.append("import java.util.List;\r\n"
//						+ "import com.mantoto.page.Pager;\r\n");
//				importStr.append("\r\nimport " + beanPackage + "." + item + ";\r\n");
//				JavaFileTemple.analysisDataConntent(packageStr, importStr.toString(), item, beanPackage, map);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	/**
	 * 生成接口
	 * 
	 * @param packageStr
	 * @param beanPackage
	 */
//	public void createJavaContorllerInterface(String packageStr, String beanPackage, String Suffix, String prefix) {
//		JavaFileTemple = new JavaContorllerIterfaceTemplet();
//		JavaFileTemple.setPrefix(prefix);
//		JavaFileTemple.setSuffix(Suffix);
//		try {
//			if (null == tableNames) {
//				tableNames = Jdbc_Connection.GetTableNames(analysisCofigInfo.getTableSql());
//			}
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("HttpServletRequest", "request");
//			map.put("HttpServletResponse", "response");
//			map.put("ModelAndView", "modelAndView");
//
//			for (String item : tableNames) {
//				importStr = new StringBuffer();
//				importStr.append("\r\nimport javax.servlet.http.HttpServletResponse;"
//						+ "\r\nimport javax.servlet.http.HttpServletRequest;"
//						+ "\r\nimport org.springframework.web.servlet.ModelAndView;");
//				importStr.append("\r\nimport " + beanPackage + "." + item + ";\r\n");
//				JavaFileTemple.analysisDataConntent(packageStr, importStr.toString(), item, beanPackage, map);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	/**
	 * 生成XML
	 * 
	 * @param packageStr
	 * @param beanPackage
	 * @param Suffix
	 * @param basePackage
	 * @param baseSuffix
	 * @param basePrefix
	 */
//	public void createMapperXml(String packageStr, String beanPackage, String Suffix, String basePackage,
//			String baseSuffix, String basePrefix, String tableNamePrefix) {
//		JavaFileTemple = new FileMapperXmlTemplet();
//		JavaFileTemple.setTableNamePrefix(tableNamePrefix);
//		JavaFileTemple.setSuffix(Suffix);
//		try {
//			if (null == tableNames) {
//				tableNames = Jdbc_Connection.GetTableNames(analysisCofigInfo.getTableSql());
//			}
//			for (String item : tableNames) {
//				JavaFileTemple.setBaseInterfceName(basePackage + "." + basePrefix + item + baseSuffix);
//				importStr = new StringBuffer();
//				importStr.append("import java.util.List;\r\n");
//				importStr.append("import " + beanPackage + "." + item + ";\r\n");
//				JavaFileTemple.analysisDataConntent(packageStr, importStr.toString(), item, beanPackage, null);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	/**
	 * 生成Service实现层
	 * 
	 * @param benPackage
	 * @param packageStr
	 * @param Suffix
	 * @param basePackage
	 * @param baseSuffix
	 * @param basePrefix
	 * @param netPackage
	 * @param netSuffix
	 * @param netPrefix
	 */
//	public void createJavaServiceImpl(String benPackage, String packageStr, String Suffix, String basePackage,
//			String baseSuffix, String basePrefix, String netPackage, String netSuffix, String netPrefix) {
//		JavaFileTemple = new JavaIterfaceServiceImplTemplate();
//		JavaFileTemple.setClassAnnotation("@Service");
//		JavaFileTemple.setPramAnnotation("@Autowired");
//		JavaFileTemple.setSuffix(Suffix);
//
//		JavaFileTemple.setNetPackage(netPackage);
//		JavaFileTemple.setNetPrefix(netPrefix);
//		JavaFileTemple.setNetSuffix(netSuffix);
//
//		try {
//			if (null == tableNames) {
//				tableNames = Jdbc_Connection.GetTableNames(analysisCofigInfo.getTableSql());
//			}
//			for (String item : tableNames) {
//				JavaFileTemple.setBaseInterfceName(basePackage + "." + basePrefix + item + baseSuffix);
//				importStr = new StringBuffer();
//				importStr.append(
//						"\r\nimport java.util.List;"
//						+ "\r\nimport com.mantoto.page.Pager;"
//						+ "\r\nimport org.springframework.stereotype.Service;"
//						+ "\r\nimport java.sql.Timestamp;"
//						+ "\r\nimport com.mantoto.util.MyJsonView;"
//						+ "\r\nimport com.mantoto.util.Validate;"
//						+ "\r\nimport com.mantoto.util.CreateUniqId;"
//						+ "\r\nimport com.mantoto.open.service.base.OpenServiceBase;"
//						+ "\r\nimport com.mantoto.product.jsonView.ProductSelectCondition;"
//						+ "\r\nimport org.springframework.beans.factory.annotation.Autowired;");
//				
//				importStr.append("import " + netPackage + "." + netPrefix + item + netSuffix + ";\r\n");
//				importStr.append("import " + benPackage + "." + item + ";\r\n");
//				JavaFileTemple.analysisDataConntent(packageStr, importStr.toString(), item,benPackage, null);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

//	public void createJavaContorllerImpl(String benPackage, String packageStr, String Suffix, String basePackage,
//			String baseSuffix, String basePrefix, String netPackage, String netSuffix, String netPrefix) {
//		JavaFileTemple = new JavaIterfaceImplContorllerTemplate();
//		JavaFileTemple.setJsonView("ProductView");
//		JavaFileTemple.setClassAnnotation("@Controller");
//		JavaFileTemple.setPramAnnotation("@Autowired");
//		JavaFileTemple.setSuffix(Suffix);
//
//		JavaFileTemple.setNetPackage(netPackage);
//		JavaFileTemple.setNetPrefix(netPrefix);
//		JavaFileTemple.setNetSuffix(netSuffix);
//
//		try {
//			if (null == tableNames) {
//				tableNames = Jdbc_Connection.GetTableNames(analysisCofigInfo.getTableSql());
//			}
//			for (String item : tableNames) {
//				JavaFileTemple.setBaseInterfceName(basePackage + "." + basePrefix + item + baseSuffix);
//				importStr = new StringBuffer();
//				importStr.append("import java.util.List;" + "\r\nimport org.springframework.stereotype.Controller;"
//						+ "\r\nimport javax.servlet.http.HttpServletResponse;"
//						+ "\r\nimport javax.servlet.http.HttpServletRequest;"
//						+ "\r\nimport org.springframework.web.servlet.ModelAndView;"
//						+ "\r\nimport java.util.HashMap;"
//						+ "\r\nimport java.util.Map;"
//						+ "\r\nimport com.mantoto.page.Pager;"
//						+ "\r\nimport com.mantoto.controller.base.ControllerBase;"
//						+ "\r\nimport com.mantoto.product.jsonView.ProductView;"
//						+ "\r\nimport com.mantoto.util.MyJsonView;"
//						+ "\r\nimport org.springframework.web.bind.annotation.RequestMethod;"
//						+ "\r\nimport org.springframework.web.bind.annotation.RequestMapping;"
//						+ "\r\nimport org.springframework.beans.factory.annotation.Autowired;");
//				
//				
//				importStr.append("import " + netPackage + "." + netPrefix + item + netSuffix + ";\r\n");
//				importStr.append("import " + benPackage + "." + item + ";\r\n");
//				JavaFileTemple.analysisDataConntent(packageStr, importStr.toString(), item,benPackage, null);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
    /**
     * 生成测试类
     * @param packageName
     * @param testPackageName
     */
//	public void createJavaTestFile(String packageName, String testPackageName) {
//		Set<Class<?>> clasSet = FindClasses.getClasses(packageName, false);
//		JavaFileTemple = new JavaJunitSpringTestTemplet();
//		for (Class cls : clasSet) {
//			JavaFileTemple.analysisDataConntent(cls, testPackageName);
//		}
//
//	}
	
//	public void createJavaCacheInterface(String packageStr, String beanPackage, String Suffix, String prefix){
//		JavaFileTemple = new JavaIterfaceCacheTemplet();
//		JavaFileTemple.setPrefix(prefix);
//		JavaFileTemple.setSuffix(Suffix);
//		try {
//			if (null == tableNames) {
//				tableNames = Jdbc_Connection.GetTableNames(analysisCofigInfo.getTableSql());
//			}
//
//			for (String item : tableNames) {
//				importStr = new StringBuffer();
//				importStr.append("\r\nimport java.util.List;\r\nimport com.mantoto.page.Pager;");
//				importStr.append("\r\nimport com.mantoto.cache.base.ICacheBase;");
//				importStr.append("\r\nimport " + beanPackage + "." + item + ";\r\n");
//				
//				JavaFileTemple.analysisDataConntent(packageStr, importStr.toString(), item, beanPackage, null);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//	public void createJavaCacheInterfaceImpl(String benPackage, String packageStr, String Suffix, String basePackage,
//			String baseSuffix, String basePrefix){
//		
//		
//		JavaFileTemple = new JavaIterfaceCacheImplTemplate();
//		JavaFileTemple.setClassAnnotation("@Service");
//		JavaFileTemple.setSuffix(Suffix);
//
//
//		try {
//			if (null == tableNames) {
//				tableNames = Jdbc_Connection.GetTableNames(analysisCofigInfo.getTableSql());
//			}
//			for (String item : tableNames) {
//				JavaFileTemple.setBaseInterfceName(basePackage + "." + basePrefix + item + baseSuffix);
//				importStr = new StringBuffer();
//				importStr.append(
//						"\r\nimport java.util.List;\r\nimport org.springframework.stereotype.Service;\r\nimport com.mantoto.redis.RedisBase;\r\nimport com.mantoto.page.Pager;");
//				
//				importStr.append("import " + benPackage + "." + item + ";\r\n");
//				JavaFileTemple.analysisDataConntent(packageStr, importStr.toString(), item,benPackage, null);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	


	/**
	 * 生成Service实现层
	 * 
	 * @param benPackage
	 * @param packageStr
	 * @param Suffix
	 * @param basePackage
	 * @param baseSuffix
	 * @param basePrefix
	 * @param netPackage
	 * @param netSuffix
	 * @param netPrefix
	 */
//	public void createJavaServiceCacheImpl(
//			String benPackage, String packageStr, String Suffix, 
//			String basePackage,String baseSuffix, String basePrefix, 
//			String netPackage, String netSuffix, String netPrefix,
//			String netCachePackage,String netCachePrefix , String netCacheSuffix) {
//		
//		JavaFileTemple = new JavaIterfaceServiceCacheImplTemplate();
//		JavaFileTemple.setClassAnnotation("@Service");
//		JavaFileTemple.setPramAnnotation("@Autowired");
//		JavaFileTemple.setSuffix(Suffix);
//
//		JavaFileTemple.setNetPackage(netPackage);
//		JavaFileTemple.setNetPrefix(netPrefix);
//		JavaFileTemple.setNetSuffix(netSuffix);
//
//		JavaFileTemple.setNetCachePackage(netCachePackage);
//		JavaFileTemple.setNetCachePrefix(netCachePrefix);
//		JavaFileTemple.setNetCacheSuffix(netCacheSuffix);
//		try {
//			if (null == tableNames) {
//				tableNames = Jdbc_Connection.GetTableNames(analysisCofigInfo.getTableSql());
//			}
//			for (String item : tableNames) {
//				JavaFileTemple.setBaseInterfceName(basePackage + "." + basePrefix + item + baseSuffix);
//				importStr = new StringBuffer();
//				importStr.append(
//						"import java.util.List;\r\nimport org.springframework.stereotype.Service;"
//								+ "\r\nimport com.mantoto.page.Pager;"
//								+ "\r\nimport com.mantoto.service.base.ServiceBase;"
//						+ "\r\nimport org.springframework.beans.factory.annotation.Autowired;");
//				importStr.append("import " + netPackage + "." + netPrefix + item + netSuffix + ";\r\n");
//				importStr.append("import " + benPackage + "." + item + ";\r\n");
//				JavaFileTemple.analysisDataConntent(packageStr, importStr.toString(), item,benPackage, null);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
