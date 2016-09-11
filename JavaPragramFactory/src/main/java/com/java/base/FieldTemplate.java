package com.java.base;

import com.java.mantoto.mould.emun.Qualifier;

public class FieldTemplate extends TemplateJavaBase {

	private String fieldAnnotation;
	private String fieldType;
	private String fieldName;

	private Qualifier fieldQualifier;
	
	public String getFieldAnnotation() {
		return fieldAnnotation;
	}

	public void setFieldAnnotation(String fieldAnnotation) {
		this.fieldAnnotation = fieldAnnotation;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	@Override
	public String getTemplateStr() {
		// TODO Auto-generated method stub
		return super.getTemplateStr(this);
	}

	public String getFieldQualifier() {
		return fieldQualifier.getName();
	}

	public void setFieldQualifier(Qualifier fieldQualifier) {
		this.fieldQualifier = fieldQualifier;
	}


	
}
