package com.java.base;

import java.util.List;

public class ClassTemplate extends TemplateJavaBase {

	private String pagckage;
	private String importStr;
	private ClassType classType;
	private String javaName;
	private String extendsBase;
	private String implementsBase;

	
	List<EnumConstantTemplate> enums;
	
	List<FieldTemplate> fields;

	List<IMethodTemplate> methods;

	public String getPagckage() {
		return pagckage;
	}

	public void setPagckage(String pagckage) {
		this.pagckage = pagckage;
	}

	public String getImportStr() {
		return importStr;
	}

	public void setImportStr(String importStr) {
		this.importStr = importStr;
	}

	public String getClassType() {
		if (null != classType)
			return classType.getValue();
		return "";
	}

	public void setClassType(ClassType classType) {
		this.classType = classType;
	}

	public String getJavaName() {
		return javaName;
	}

	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}

	public String getExtendsBase() {
		return extendsBase;
	}

	public void setExtendsBase(String extendsBase) {
		this.extendsBase = extendsBase;
	}

	public String getImplementsBase() {
		return implementsBase;
	}

	public void setImplementsBase(String implementsBase) {
		this.implementsBase = implementsBase;
	}

	public String getFields() {
		if(null==fields) return "";
		StringBuffer buffer = new StringBuffer();
		for (FieldTemplate fieldTemplate : fields) {
			buffer.append("\n");
			buffer.append(fieldTemplate.getTemplateStr());
		}
		return buffer.toString();
	}

	public void setFields(List<FieldTemplate> fields) {
		this.fields = fields;
	}

	public String getMethods() {
		if(null==methods) return "";
		StringBuffer buffer = new StringBuffer();
	
		for (IMethodTemplate methodTemplate : methods) {
			buffer.append("\n");
			buffer.append(methodTemplate.getTemplateStr());
		}
		return buffer.toString();
	}

	public void setMethods(List<IMethodTemplate> methods) {
		this.methods = methods;
	}

	@Override
	public String getTemplateStr() {
		// TODO Auto-generated method stub
		return super.getTemplateStr(this);
	}

	public String getEnums() {
		if(null==enums) return "";
		StringBuffer buffer=new StringBuffer();
		
		for(EnumConstantTemplate enumConstant: enums){
			buffer.append(enumConstant.getTemplateStr());
		}
		
		return buffer.toString();
	}

	public void setEnums(List<EnumConstantTemplate> enums) {
		this.enums = enums;
	}

}
