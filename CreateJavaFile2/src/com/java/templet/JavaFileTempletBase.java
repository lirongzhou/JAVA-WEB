package com.java.templet;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import com.mantoto.annotation.ValidateAnnotaion;
import com.mantoto.base.bean.BeanBase;
import com.mantoto.cache.base.ICacheBase;
import com.mytools.file.CrateJavaFile;
import com.mytools.file.FileBasicOperation;

public abstract class JavaFileTempletBase {

	protected CrateJavaFile crate = new CrateJavaFile();
	protected String SELECT = "select";
	protected String DELETE = "delete";
	protected String UPDATE = "update";
	protected String INSSERT = "insert";
	protected String SELECTCOUNT = "selectCount";
	protected String UPDATECACHEID = "updateCacheById";
	protected String UPDATECACHEALL = "updateCacheAll";
	protected String SELECTBYID="selectById";
	protected String netCachePackage; 
	protected String netCachePrefix ; 
	protected String netCacheSuffix;
	protected String jsonView;
	protected String beanPackage;
	protected String beanName;
	
	public void resetMethodPrefix() {
		SELECT = "select";
		DELETE = "delete";
		UPDATE = "update";
		INSSERT = "insert";
		SELECTCOUNT = "selectCount";
		UPDATECACHEID = "updateCacheById";
		UPDATECACHEALL = "updateCacheAll";
		SELECTBYID="selectById";
	}

	public String getNetCachePackage() {
		return netCachePackage;
	}

	public String getJsonView() {
		return jsonView;
	}

	public void setJsonView(String jsonView) {
		this.jsonView = jsonView;
	}

	public void setNetCachePackage(String netCachePackage) {
		this.netCachePackage = netCachePackage;
	}

	public String getNetCachePrefix() {
		return netCachePrefix;
	}

	public void setNetCachePrefix(String netCachePrefix) {
		this.netCachePrefix = netCachePrefix;
	}

	public String getNetCacheSuffix() {
		return netCacheSuffix;
	}

	public void setNetCacheSuffix(String netCacheSuffix) {
		this.netCacheSuffix = netCacheSuffix;
	}

	protected String baseInterfceName;

	private String tableNamePrefix;

	private String primaryKey;

	public String getPrimaryKey() {
		return primaryKey;
	}

	public String getTableNamePrefix() {
		return tableNamePrefix;
	}

	public void setTableNamePrefix(String tableNamePrefix) {
		this.tableNamePrefix = tableNamePrefix;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	/**
	 * 依赖类的包名
	 */
	public String netPackage;
	/**
	 * 依赖类的后缀
	 */
	public String netSuffix;
	/**
	 * 依赖类的前缀
	 */
	private String netPrefix;

	public String getNetPrefix() {
		return netPrefix;
	}

	public void setNetPrefix(String netPrefix) {
		this.netPrefix = netPrefix;
	}

	public String getBaseInterfceName() {
		return baseInterfceName;
	}

	public void setBaseInterfceName(String baseInterfceName) {
		this.baseInterfceName = baseInterfceName;
	}

	protected String pr = "private  ";
	/**
	 * 前缀
	 */
	private String prefix = "";

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	private String suffix = "";

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getNetPackage() {
		return netPackage;
	}

	public void setNetPackage(String netPackage) {
		this.netPackage = netPackage;
	}

	public String getNetSuffix() {
		return netSuffix;
	}

	public void setNetSuffix(String netSuffix) {
		this.netSuffix = netSuffix;
	}

	/**
	 * 类的注解
	 */
	private String classAnnotation;
	/**
	 * 参数的注解
	 */
	private String pramAnnotation;

	public String getClassAnnotation() {
		return classAnnotation;
	}

	public void setClassAnnotation(String classAnnotation) {
		this.classAnnotation = classAnnotation;
	}

	public String getPramAnnotation() {
		return pramAnnotation;
	}

	public void setPramAnnotation(String pramAnnotation) {
		this.pramAnnotation = pramAnnotation;
	}

	/**
	 * 
	 * @param packag
	 * @param className
	 * @return
	 */
	public String javaFileabstractHead(String packag, String importJar, String className) {
		return "package " + packag + ";\r\n" + importJar + " \r\n" + "public abstract class " + className + "{\r\n";
	}
	 
	 
	 public String javaFileInterfaceCacheHead(String packag, String importJar, String className) {
			return "package " + packag + "; \r\n" + importJar + "\r\n" + "public interface " + className + "  extends ICacheBase{\r\n";
	 }
	 public String javaFileInterfaceServiceHead(String packag, String importJar, String className) {
			return "package " + packag + "; \r\n" + importJar + "\r\n" + "public interface " + className + "{\r\n";
	 }
	 
	public String javaFileInterfaceHead(String packag, String importJar, String className) {
		return "package " + packag + "; \r\n" + importJar + "\r\n" + "public interface " + className + "{\r\n";
	}

	public String javaFileHead(String packag, String importJar, String className) {
		System.out.println("package " + packag + ";\r\n" + importJar + " \r\n" + "public class " + className + "{\r\n");
		return "package " + packag + ";\r\n" + importJar + " \r\n" + "public class " + className + "{\r\n";
	}
	public String javaFileHead(String packag, String importJar, String className,String baseName) {
		if(isNull(baseName)){
			return javaFileHead( packag,  importJar,  className) ;
		}
//		System.out.println("package " + packag + ";\r\n" + importJar + " \r\n" + "public class " + className + "{\r\n");
		return "package " + packag + ";\r\n" + importJar + " \r\n" + "public class " + className + " extends  "+baseName+"{\r\n";
	}
	public String javaFileInterfaceImplHead(String packag, String importJar, String className) {
		System.out.println("package " + packag + ";\r\n" + importJar + " \r\n" + this.getClassAnnotation()
				+ " \r\n public class " + className + "{\r\n");
		return "package " + packag + ";\r\n" + importJar + " \r\n" + this.getClassAnnotation() + "\r\npublic class "
				+ className + "{\r\n";
	}

	/**
	 * 生成一个接口
	 */
	public String interfaceMethod(String interfaceMethodTemplet, String entityClassName) {

		if (SELECT.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "(" + entityClassName + "  "
					+ entityClassName.toLowerCase() + " );\r\n";
		} else if (DELETE.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "(String id );\r\n";
		} else if (UPDATE.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "(" + entityClassName + "  "
					+ entityClassName.toLowerCase() + " );\r\n";
		} else if (INSSERT.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "(" + entityClassName + "  "
					+ entityClassName.toLowerCase() + " );\r\n";
		} else if (SELECTCOUNT.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "(" + entityClassName + "  "
					+ entityClassName.toLowerCase() + " );\r\n";
		} else if (UPDATECACHEID.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "( String id );\r\n";
		} else if (UPDATECACHEALL.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName +"();\r\n";
		}else if(SELECTBYID.equals(interfaceMethodTemplet)){
			return interfaceMethodTemplet + entityClassName + "(String id );\r\n";
		}
		
		return "";
	}

	/**
	 * 生成一个接口
	 */
	public String interfaceMethod(String interfaceMethodTemplet, String entityClassName,
			Map<String, String> customParam) {

		if (SELECT.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "(" + entityClassName + "  "
					+ entityClassName.toLowerCase() + " );\r\n";
		} else if (DELETE.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "(String id );\r\n";
		} else if (UPDATE.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "(" + entityClassName + "  "
					+ entityClassName.toLowerCase() + " );\r\n";
		} else if (INSSERT.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "(" + entityClassName + "  "
					+ entityClassName.toLowerCase() + " );\r\n";
		} else if (SELECTCOUNT.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "(" + entityClassName + "  "
					+ entityClassName.toLowerCase() + " );\r\n";
		}
		return "";
	}

	/**
	 * 生成一个接口
	 */
	public String interfaceMethod(String interfaceMethodTemplet, String entityClassName, String entityPackage) {
		Class clas = null;
		try {
			clas = Class.forName(entityPackage + "." + entityClassName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			clas = null;
		}
		if (SELECT.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "(" + entityClassName + "  "
					+ entityClassName.toLowerCase() + " );\r\n";
		} else if (DELETE.equals(interfaceMethodTemplet)) {
			if (isNull(clas)) {
				return interfaceMethodTemplet + entityClassName + "(String id );\r\n";
			} else {
				String fieldName = this.getFieldId(clas.getDeclaredFields());
				if (!isNull(fieldName)) {
					fieldName = strTopCharToLower(fieldName);
					return interfaceMethodTemplet + entityClassName + "(String " + fieldName + ");\r\n";
				} else
					return interfaceMethodTemplet + entityClassName + "(String id );\r\n";
			}

		} else if (UPDATE.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "(" + entityClassName + "  "
					+ entityClassName.toLowerCase() + " );\r\n";
		} else if (INSSERT.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "(" + entityClassName + "  "
					+ entityClassName.toLowerCase() + " );\r\n";
		} else if (SELECTCOUNT.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "(" + entityClassName + "  "
					+ entityClassName.toLowerCase() + " );\r\n";
		}else if (UPDATECACHEID.equals(interfaceMethodTemplet)) {
			if (isNull(clas)) {
				return interfaceMethodTemplet + entityClassName + "(String id );\r\n";
			} else {
				String fieldName = this.getFieldId(clas.getDeclaredFields());
				if (!isNull(fieldName)) {
					fieldName = strTopCharToLower(fieldName);
					return interfaceMethodTemplet + entityClassName + "(String " + fieldName + ");\r\n";
				} else
					return interfaceMethodTemplet + entityClassName + "(String id );\r\n";
			}
		} else if (UPDATECACHEALL.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName +"();\r\n";
		}else if(SELECTBYID.equals(interfaceMethodTemplet)){
			if (isNull(clas)) {
				return interfaceMethodTemplet + entityClassName + "(String id );\r\n";
			} else {
				String fieldName = this.getFieldId(clas.getDeclaredFields());
				if (!isNull(fieldName)) {
					fieldName = strTopCharToLower(fieldName);
					return interfaceMethodTemplet + entityClassName + "(String " + fieldName + ");\r\n";
				} else
					return interfaceMethodTemplet + entityClassName + "(String id );\r\n";
			}
		}
		return "";
	}

	public String interfaceMethod(String interfaceMethodTemplet, String entityClassName, String entityPackage,
			Map<String, String> customParam) {
		
		if(isNull(customParam)||!(customParam.size()>0)){
			return interfaceMethod( interfaceMethodTemplet,  entityClassName,  entityPackage) ;
			
		}
		Class clas = null;
		try {
			clas = Class.forName(entityPackage + "." + entityClassName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			clas = null;
		}
		if (SELECT.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "(" + entityClassName + "  "
					+ entityClassName.toLowerCase() + "," + analysisCustomParam(customParam) + ");\r\n";
		} else if (DELETE.equals(interfaceMethodTemplet)) {
			if (isNull(clas)) {
				return interfaceMethodTemplet + entityClassName + "(String id );\r\n";
			} else {
				String fieldName = this.getFieldId(clas.getDeclaredFields());
				if (!isNull(fieldName)) {
					fieldName = strTopCharToLower(fieldName);
					return interfaceMethodTemplet + entityClassName + "(String " + fieldName + ","
							+ analysisCustomParam(customParam) + ");\r\n";
				} else
					return interfaceMethodTemplet + entityClassName + "(String id ," + analysisCustomParam(customParam)
							+ " );\r\n";
			}

		} else if (UPDATE.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "(" + entityClassName + "  "
					+ entityClassName.toLowerCase() + "," + analysisCustomParam(customParam) + " );\r\n";
		} else if (INSSERT.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "(" + entityClassName + "  "
					+ entityClassName.toLowerCase() + "," + analysisCustomParam(customParam) + " );\r\n";
		} else if (SELECTCOUNT.equals(interfaceMethodTemplet)) {
			return interfaceMethodTemplet + entityClassName + "(" + entityClassName + "  "
					+ entityClassName.toLowerCase() + "," + analysisCustomParam(customParam) + " );\r\n";
		}else if(SELECTBYID.equals(interfaceMethodTemplet)){
			if (isNull(clas)) {
				return interfaceMethodTemplet + entityClassName + "(String id ,"+analysisCustomParam(customParam)+");\r\n";
			} else {
				String fieldName = this.getFieldId(clas.getDeclaredFields());
				if (!isNull(fieldName)) {
					fieldName = strTopCharToLower(fieldName);
					return interfaceMethodTemplet + entityClassName + "(String " + fieldName +","+analysisCustomParam(customParam)+ ");\r\n";
				} else
					return interfaceMethodTemplet + entityClassName + "(String id ,"+analysisCustomParam(customParam)+");\r\n";
			}
		}
		return "";
	}

	public String analysisCustomParam(Map<String, String> customParam) {
		StringBuffer buffer = new StringBuffer();
		for (Entry<String, String> entry : customParam.entrySet()) {
			buffer.append(entry.getKey());
			buffer.append(" ");
			buffer.append(entry.getValue());
			buffer.append(",");
		}
		buffer.delete(buffer.length() - 1, buffer.length());
		return buffer.toString();
	}

	public void setInterfaceMethodTemplate(String entityClassName) {
		SELECT = "\r\n public List<" + entityClassName + "> " + SELECT;
		SELECTCOUNT = "\r\n public int " + SELECTCOUNT;
		DELETE = "\r\n public int " + DELETE;
		UPDATE = "\r\n public int " + UPDATE;
		INSSERT = "\r\n public  int "+INSSERT;
		SELECTBYID = "\r\n public "+entityClassName+" " + SELECTBYID;

	}
	public void setInterfaceCacheTemplate(String entityClassName){
		SELECT = "\r\n public Pager " + SELECT;
		SELECTBYID = "\r\n public "+entityClassName+" " + SELECTBYID;
		SELECTCOUNT = "\r\n public int " + SELECTCOUNT;
		DELETE = "\r\n public boolean  remove" ;
		this.UPDATECACHEALL="\r\n public boolean "+UPDATECACHEALL;
		this.UPDATECACHEID="\r\n public boolean "+UPDATECACHEID;
	}
	
	public void setInterfaceServiceMethodTemplate(String entityClassName) {
		SELECT = "\r\n public Pager " + SELECT;
		SELECTBYID = "\r\n public "+entityClassName+" " + SELECTBYID;
		SELECTCOUNT = "\r\n public int " + SELECTCOUNT;
		DELETE = "\r\n public boolean " + DELETE;
		UPDATE = "\r\n public boolean " + UPDATE;
		INSSERT = "\r\n public  long "+INSSERT;

	}
	public void setInterfaceCountrollerMethodTemplate() {
		SELECT = "\r\n public  ModelAndView " + SELECT;
		SELECTCOUNT = "\r\n public ModelAndView " + SELECTCOUNT;
		DELETE = "\r\n public ModelAndView " + DELETE;
		UPDATE = "\r\n public ModelAndView  " + UPDATE;
		INSSERT = "\r\n public ModelAndView " + INSSERT;
		SELECTBYID = "\r\n public ModelAndView  "+ SELECTBYID;
	}

	public String javaFileEnd() {

		return "\r\n}";
	}

	public String setMethod(String returnStr, String methodName, String paramType, String parameter, String thisParam) {

		StringBuffer setMethod = new StringBuffer();
		setMethod.append("\r\npublic ");
		setMethod.append(returnStr);
		setMethod.append(" " + methodName + "(" + paramType + " " + parameter + "){\r\n");
		setMethod.append("\r\n this." + thisParam + "=" + parameter + ";\r\n");
		setMethod.append("}\r\n ");

		return setMethod.toString();
	}

	public String getMethod(String returnStr, String methodName, String returnParameter) {

		StringBuffer getMethod = new StringBuffer();
		getMethod.append("\r\npublic ");
		getMethod.append(returnStr);
		getMethod.append(" " + methodName + "(){\r\n");
		getMethod.append("\r\nreturn this." + returnParameter + ";\r\n");
		getMethod.append("} \r\n");

		return getMethod.toString();
	}

	public abstract boolean analysisDataConntent(String packag, String importJar, String className, String beanPackage,
			Map map);

	public abstract boolean analysisDataConntent(String packag, String importJar, String className, Map map);

	public boolean analysisDataConntent(Class clas, String packag) {
		return false;
	}

	FileBasicOperation fileBasicOperation = new FileBasicOperation();

	String sysPath = System.getProperty("user.dir");

	String outPath = sysPath + "\\bin\\";
	String tagetPathSrc = sysPath + "\\src\\";

	/**
	 * 编译java文件
	 * 
	 * @param packag
	 * @param fileName
	 * @return
	 */
	public boolean compiler(String packag, String fileName) {
		try {
			String packagPath = packag.replace('.', '\\');
			JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
			int result = javaCompiler.run(null, null, null, tagetPathSrc + packagPath + "\\" + fileName + ".java");
			if (result == 0) {
				return fileBasicOperation.removeFile(fileName + ".class", tagetPathSrc + packagPath,
						outPath + packagPath, true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return false;
	}

	protected boolean isNull(Object o) {
		return null == o || "" == o || "".equals(o) ? true : false;
	}

	protected String getFieldId(Field[] fields) {
		for (Field field : fields) {

			if (field.isAnnotationPresent(ValidateAnnotaion.class)) {
				ValidateAnnotaion validaeAnnotation = field.getAnnotation(ValidateAnnotaion.class);
				if (validaeAnnotation.isId() == ValidateAnnotaion.IsId.TRUE) {
					return field.getName();
				}
			}
		}
		return "";
	}

	protected String strTopCharToUpperCase(String fieldName) {
		char[] chars = fieldName.toCharArray();
		chars[0] = Character.toUpperCase(chars[0]);
		String fieldNameUpperCase = new String(chars);
		return fieldNameUpperCase;
	}

	protected String strTopCharToLower(String className) {
		char[] chars = className.toCharArray();
		chars[0] = Character.toLowerCase(chars[0]);
		className = new String(chars);
		return className;
	}
}
