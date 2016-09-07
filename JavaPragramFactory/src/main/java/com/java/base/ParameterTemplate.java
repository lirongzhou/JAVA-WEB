package com.java.base;

public class ParameterTemplate extends TemplateJavaBase {
	private String parameterType;
	private String parameterName;

	// #{parameterType} #{parameterName}
	public String getParameterType() {
		return parameterType;
	}

	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	@Override
	public String getTemplateStr() {
		// TODO Auto-generated method stub
		return super.getTemplateStr(this);
	}
}
