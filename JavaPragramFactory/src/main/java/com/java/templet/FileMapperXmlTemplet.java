package com.java.templet;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import com.mantoto.annotation.ValidateAnnotaion;

public class FileMapperXmlTemplet extends JavaFileTempletBase {

	private  String includeColumnsId="";
    private String includeSqlWhereId="";
	
	@Override
	public boolean analysisDataConntent(String packag, String importJar, String className, String beanPackage,
			Map map) {
		
		// TODO Auto-generated method stub
		StringBuffer conntext = new StringBuffer();
		conntext.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> ");
		conntext.append("\r\n");

		conntext.append("<!DOCTYPE mapper ");
		conntext.append("\r\n");
		conntext.append("PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"");
		conntext.append("\r\n");

		conntext.append("\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
		conntext.append("\r\n");
		conntext.append("<mapper namespace=\"" + super.getBaseInterfceName());
		conntext.append("\">");
		conntext.append("\r\n");
		
		if(isNull(includeColumnsId)){
			conntext.append(setIncludeIdName(beanPackage+"."+className));
			conntext.append("\r\n");
		}
		if(isNull(includeSqlWhereId)){
			conntext.append(setIncludeSqlWhereId(beanPackage+"."+className));
			conntext.append("\r\n");
		}
		try {
			Class c = Class.forName(this.getBaseInterfceName());

			Method[] methods = c.getMethods();
			for (Method m : methods) {
				if (m.getName().contains(DELETE)) {
					conntext.append("<delete id=\"" + m.getName() + "\" parameterType=\"" + getParameters(m) + "\">");
					conntext.append("\r\n");
					conntext.append("</delete>");
					conntext.append("\r\n");
				} else if (m.getName().contains(INSSERT)) {
					conntext.append("<insert id=\"" + m.getName() + "\" parameterType=\"" + getParameters(m) + "\" > ");
					conntext.append("\r\n");
					conntext.append(createInsertSql(beanPackage+"."+className));
					conntext.append("</insert>  ");
					conntext.append("\r\n");

				} else if (m.getName().contains(UPDATE)) {

					conntext.append("<update id=\"" + m.getName() + "\" parameterType=\"" + getParameters(m) + "\" >");
					conntext.append("\r\n");
					conntext.append(createUpdateSql(beanPackage+"."+className));
					conntext.append(" </update>");
					conntext.append("\r\n");

				} else if (m.getName().contains(SELECT) && !m.getName().contains("selectCount")&&!m.getName().startsWith(super.SELECTBYID)) {

					conntext.append("<select id=\"" + m.getName() + "\"   parameterType=\"" + getParameters(m)
							+ "\"  resultMap=\"" + getReturnType(m) + "\" >");
					conntext.append("\r\n");
					conntext.append(createSelectSQL(beanPackage+"."+className));
					conntext.append("</select>");
					conntext.append("\r\n");
					conntext.append(getResultMap(beanPackage+"."+className));
				} else if (m.getName().contains(SELECTCOUNT)) {
					String retrunType=getReturnType(m);
					if(retrunType.equals("int")){
						retrunType="java.lang.Integer";
					}
					conntext.append("<select id=\"" + m.getName() + "\"   parameterType=\"" + getParameters(m)
							+ "\"  resultType=\"" + retrunType + "\" >");
					conntext.append("\r\n");
					conntext.append(this.createSelectCountSql(beanPackage+"."+className));
					conntext.append("</select>");
					conntext.append("\r\n");
				}else if(m.getName().startsWith(SELECTBYID)){

					conntext.append("<select id=\"" + m.getName() + "\"   parameterType=\"" + getParameters(m)
							+ "\"  resultMap=\"" + getReturnType(m) + "\" >");
					conntext.append("\r\n");
					conntext.append(createSelectByIdSQL( beanPackage+"."+className));
					conntext.append("</select>");
					conntext.append("\r\n");
				}

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conntext.append("</mapper> ");
		 clean();
		return crate.CreateJava(className + super.getSuffix(), packag, conntext.toString(), "xml");

	}
//	 <include refid="Column_List" />
//	  <sql id="Column_List" >
//	    AdministratorId, UserId
//	  </sql>
     public String getIncludeXml(String includeIdName){
    	 
    	 return "<include refid=\""+includeIdName+"\" />";
     }
	 
     public void clean(){
    		includeColumnsId="";
    	    includeSqlWhereId="";
     }
     
     public String setIncludeSqlWhereId(String classPath){
    	 try {
    		 StringBuffer buffer=new StringBuffer();
 			Class clas = Class.forName(classPath);
 			Field[] fields=clas.getDeclaredFields();
 			includeSqlWhereId="sql_Where";
 			buffer.append("  <sql id=\""+includeSqlWhereId+"\" >");
 			buffer.append( createSelectCondition(fields));
 			buffer.append("</sql>");
 			return buffer.toString();
 		} catch (ClassNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    	 return "";
     }
	public String setIncludeIdName(String clasPath){
		  try {
			Class	clas = Class.forName(clasPath);
		    this.includeColumnsId="column_List";
			StringBuffer buffer = new StringBuffer();
			buffer.append("  <sql id=\""+includeColumnsId+"\" >");
			Field[] fields = clas.getDeclaredFields();
		
			for (Field field : fields) {
				buffer.append(strTopCharToUpperCase(field.getName()) + ",");
			}
			if(buffer.toString().endsWith(",")){
				buffer.delete(buffer.length()-1, buffer.length());
			}
			buffer.append("</sql>");
			return buffer.toString();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	private Object createSelectByIdSQL(String clasPath) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		buffer.append("select ");
		Class clas;
		try {
			clas = Class.forName(clasPath);
			Field []fields =clas.getDeclaredFields();
//			for (Field field : fields) {
//				buffer.append(strTopCharToUpperCase(field.getName()) + ",");
//			}
//			if(buffer.toString().endsWith(",")){
//				buffer.delete(buffer.length()-1, buffer.length());
//			}
			buffer.append(getIncludeXml(this.includeColumnsId));
			buffer.append(" from "+clas.getSimpleName() +" where "+strTopCharToUpperCase(getFieldId(fields))+" =#{"+getFieldId(fields)+"}");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return buffer.toString();
	}

	private String createUpdateSql(String calssPath){
		try {
			Class clas = Class.forName(calssPath);
			return createUpdateSql(clas);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	private String createUpdateSql(Class clas){
		StringBuffer buffer = new StringBuffer();
		buffer.append(" UPDATE " + super.getTableNamePrefix() + clas.getSimpleName());
		buffer.append("  <trim prefix=\"SET\" suffixOverrides=\",\">   ");

		Field[] fields = clas.getDeclaredFields();
		int i = 0;
		for (Field field : fields) {
			if (i == fields.length - 1) {
				if (!isNull(createUpdateCondition(field))) {
					buffer.append(createUpdateCondition(field)).delete(buffer.lastIndexOf(","),
							buffer.lastIndexOf(",") + 1);
				} else {
					buffer.delete(buffer.lastIndexOf(","), buffer.lastIndexOf(",") + 1);
				}
			} else {
				buffer.append(createUpdateCondition(field));
			}
			i++;
		}
		buffer.append("</trim>");
		buffer.append(" where " + strTopCharToUpperCase(getFieldId(fields)) + "=#{" + getFieldId(fields) + "}");
		return buffer.toString();
		
	}
	private String createUpdateSql(Method m) {
		StringBuffer buffer = new StringBuffer();
		Class clas = getParametersClass(m);
	   return createUpdateSql( clas);
	}

	/**
	 * 生成insert sql
	 * @param classPath
	 * @return
	 */
	private String createInsertSql(String classPath) {
		try {
			Class clas = Class.forName(classPath);
			return createInsertSql(clas);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	private String createInsertSql(Class clas) {
		StringBuffer buffer = new StringBuffer();
		Field[] fields = clas.getDeclaredFields();
		buffer.append("insert into " + super.getTableNamePrefix() + clas.getSimpleName() + " (");

		for (Field field : fields) {
			buffer.append(strTopCharToUpperCase(field.getName()) + ",");
		}
		buffer.delete(buffer.length() - 1, buffer.length());
		buffer.append("");

		buffer.append(")");
		buffer.append("values(");
		for (Field field : fields) {
			buffer.append("#{" + field.getName() + "},");
		}
		buffer.delete(buffer.length() - 1, buffer.length());
		buffer.append(")");
		return buffer.toString();
	}
	private String createInsertSql(Method m) {
		StringBuffer buffer = new StringBuffer();
		Class clas = getParametersClass(m);
		return createInsertSql(clas);
	}

	private Class getParametersClass(Method m) {
		Class[] cl = m.getParameterTypes();
		for (Class c2 : cl) {
			return c2;
		}
		return null;
	}

	private String getParameters(Method m) {
		Class[] cl = m.getParameterTypes();
		StringBuffer parameterClassName = new StringBuffer();
		for (Class c2 : cl) {
			parameterClassName.append(c2.getName());
			parameterClassName.append(",");
		}
		parameterClassName.delete(parameterClassName.length() - 1, parameterClassName.length());
		return parameterClassName.toString();
	}
	// resultMap="bizApplication"

	private String getReturnType(Method m) {
		String className = classNameTopCharToLover(getActualType(m));
		return className;
	}

	private String classNameTopCharToLover(Class cl) {
		String className = cl.getSimpleName();
		className = strTopCharToLower(className);
		return className;
	}
    
	private String getResultMap(String classPath) {
		try {
			Class clas = Class.forName(classPath);
			return getResultMap(clas);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	private String getResultMap(Class clas){
		StringBuffer resultBuffer = new StringBuffer();
		resultBuffer.append(
				"<resultMap type=\"" +clas.getName() + "\" id=\"" + strTopCharToLower(clas.getSimpleName()) + "\"> \r\n ");
		Field[] fields = clas.getDeclaredFields();
		getResultProperty(resultBuffer, fields);
		resultBuffer.append("</resultMap> \r\n");
		return resultBuffer.toString();
	
	}
	private String getResultMap(Method m) {
		Class cl = m.getReturnType();
		StringBuffer resultBuffer = new StringBuffer();
		if (cl.getName().equals("java.util.List")) {
			Class clz = getActualType(m);
			if (!isNull(clz)) {
			   return getResultMap(clz);
			}else{
				return "";
			}
		} else {
			return getResultMap(cl);
		}
	}

	private Class getActualType(Method m) {
		Class cl = m.getReturnType();
		if (cl.getName().equals("java.util.List")) {
			ParameterizedType pt = (ParameterizedType) m.getGenericReturnType();
			Type[] types = pt.getActualTypeArguments();
			if (types.length > 0) {
				Class clz = (Class) pt.getActualTypeArguments()[0];
				return clz;
			} else {
				return Object.class;
			}
		}
		return m.getReturnType();
	}
    
	private void getResultProperty(StringBuffer resultBuffer, Field[] fields) {
		getResultPropertyId(resultBuffer, fields);
		for (Field field : fields) {
			String fieldName = field.getName();
			String fieldNameUpperCase = strTopCharToUpperCase(fieldName);
			if (field.isAnnotationPresent(ValidateAnnotaion.class)) {

				ValidateAnnotaion validaeAnnotation = field.getAnnotation(ValidateAnnotaion.class);
				if (validaeAnnotation.isId() != ValidateAnnotaion.IsId.TRUE) {

					resultBuffer.append("<result property=\"" + field.getName() + "\" column=\"" + fieldNameUpperCase
							+ "\" /> \r\n");
					continue;
				}
			}

		}
	}

	private void getResultPropertyId(StringBuffer resultBuffer, Field[] fields) {
		String fieldName = getFieldId(fields);
		if (!isNull(fieldName)) {
			String fieldNameUpperCase = strTopCharToUpperCase(fieldName);
			resultBuffer.append("<id property=\"" + fieldName + "\" column=\"" + fieldNameUpperCase + "\" /> \r\n");
		}
	}

	private String createSelectSQL(String classPath) {
		try {
			Class clas = Class.forName(classPath);
			return createSelectSQL(clas);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	private String createSelectSQL(Class clas) {
		
		StringBuffer buffer = new StringBuffer();

		Field[] fields = clas.getDeclaredFields();
		if (fields.length > 0) {

			buffer.append("select  top ${pageSize} ");
		}
//		for (Field field : fields) {
//			buffer.append(strTopCharToUpperCase(field.getName()) + ",");
//		}
//		buffer.delete(buffer.length() - 1, buffer.length());
		buffer.append(getIncludeXml(this.includeColumnsId));
		buffer.append(" ");
		buffer.append("from " + super.getTableNamePrefix() + clas.getSimpleName());
		buffer.append(" ");
		buffer.append(" where ");
		buffer.append(strTopCharToUpperCase(getFieldId(fields)));
		buffer.append(" ");
		buffer.append("not in (select top ${bigenRow} " + strTopCharToUpperCase(getFieldId(fields)) + " from "
				+ super.getTableNamePrefix() + clas.getSimpleName() + "  where 1=1 ");
//		buffer.append(createSelectCondition(fields));
		buffer.append(getIncludeXml(this.includeSqlWhereId));
		buffer.append(") and 1=1");
//		buffer.append(createSelectCondition(fields));
		buffer.append(getIncludeXml(this.includeSqlWhereId));
		return buffer.toString();
	}
	private String createSelectSQL(Method m) {
		Class clas = getActualType(m);
		return createSelectSQL(clas);
	}
    
	private String createSelectCountSql(String classPath){
		try {
			Class clas = Class.forName(classPath);
			return createSelectCountSql( clas);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	private String createSelectCountSql(Class clas){
		StringBuffer buffer = new StringBuffer();
		Field[] fields = clas.getDeclaredFields();
		buffer.append("select count(" + strTopCharToUpperCase(getFieldId(fields)) + ") from "
				+ super.getTableNamePrefix() + clas.getSimpleName() + " where 1=1");
//		buffer.append(createSelectCondition(fields));
		buffer.append(getIncludeXml(this.includeSqlWhereId));
		return buffer.toString();
	}
	private String createSelectCountSql(Method m) {
		// Class clas= getActualType( m);
		Class[] cls = m.getParameterTypes();
		if (isNull(cls)) {
			return "";
		}
		Class clas = cls[0];
		StringBuffer buffer = new StringBuffer();
		Field[] fields = clas.getDeclaredFields();
		buffer.append("select count(" + strTopCharToUpperCase(getFieldId(fields)) + ") from "
				+ super.getTableNamePrefix() + clas.getSimpleName() + " where 1=1");
		buffer.append(createSelectCondition(fields));
		return buffer.toString();
	}
    
	private String createSelectCondition(Field[] fields) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\r\n<trim>");
		for (Field field : fields) {
			buffer.append(createCondition(field) + "\r\n");
		}
		buffer.append("\r\n</trim>");
		return buffer.toString();
	}


	private String createUpdateCondition(Field field) {

		if (field.isAnnotationPresent(ValidateAnnotaion.class)) {
			ValidateAnnotaion validaeAnnotation = field.getAnnotation(ValidateAnnotaion.class);
			if (validaeAnnotation.isId() == ValidateAnnotaion.IsId.TRUE
					|| validaeAnnotation.canUpdate() == ValidateAnnotaion.CanUpdate.FALSE) {
				return "";
			}
		}
		String fieldType = field.getType().getSimpleName();
		String fieldName = field.getName();
		StringBuffer buffer = new StringBuffer();
		if (!fieldType.endsWith("boolean")) {
			if (fieldType.endsWith("int") || fieldType.endsWith("long") || fieldType.endsWith("double")
					|| fieldType.endsWith("float")) {
				buffer.append("\r\n");
				buffer.append(" <if test=\"" + fieldName + ">0\">  ");
				buffer.append("\r\n");
				buffer.append(strTopCharToUpperCase(fieldName) + " = #{" + fieldName + "} ,");
				buffer.append("\r\n");
				buffer.append("</if>");
			} else {
				buffer.append("\r\n");
				buffer.append("<if test=\"" + fieldName + " != null and " + fieldName + "!= '' \"> ");
				buffer.append("\r\n");
				buffer.append(strTopCharToUpperCase(fieldName) + " = #{" + fieldName + "},");
				buffer.append("\r\n");
				buffer.append("</if>");
			}
		}
		return buffer.toString();
	}

	private String createCondition(Field field) {
		String fieldType = field.getType().getSimpleName();
		String fieldName = field.getName();
		StringBuffer buffer = new StringBuffer();
		if (!fieldType.endsWith("boolean")) {
			if (fieldType.endsWith("int") || fieldType.endsWith("long") || fieldType.endsWith("double")
					|| fieldType.endsWith("float")) {
//				buffer.append("\r\n");
				buffer.append(" <if test=\"" + fieldName + ">0\">  ");
				buffer.append("\r\n");
				buffer.append("and " + strTopCharToUpperCase(fieldName) + " = #{" + fieldName + "} ");
				buffer.append("\r\n");
				buffer.append("</if>");
			} else {
//				buffer.append("\r\n");
				buffer.append("<if test=\"" + fieldName + " != null and " + fieldName + "!= '' \"> ");
				buffer.append("\r\n");
				buffer.append("and  " + strTopCharToUpperCase(fieldName) + " = #{" + fieldName + "}   ");
				buffer.append("\r\n");
				buffer.append("</if>");
			}
		}
		return buffer.toString();
	}

	@Override
	public boolean analysisDataConntent(String packag, String importJar, String className, Map map) {
		// TODO Auto-generated method stub
		return false;
	}

}
