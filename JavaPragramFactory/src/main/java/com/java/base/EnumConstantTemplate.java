package com.java.base;

import java.util.List;

public class EnumConstantTemplate  extends TemplateJavaBase{
	
	private String enumName;
	private List<ParameterTemplate> parameters;

	public String getEnumName() {
		return enumName;
	}
	public void setEnumName(String enumName) {
		this.enumName = enumName;
	}
	public String getParameters() {

		StringBuffer buffer = new StringBuffer();
		for (ParameterTemplate parameter : parameters) {
			buffer.append(parameter.getTemplateStr());
			buffer.append(",");
		}

		if (buffer.toString().endsWith(","))
			buffer.delete(buffer.length() - 1, buffer.length());

		return buffer.toString();
	}
	public void setParameters(List<ParameterTemplate> parameters) {
		this.parameters = parameters;
	}
	@Override
	public String getTemplateStr() {
		// TODO Auto-generated method stub
		return super.getTemplateStr(this);
	}
}
