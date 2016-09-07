package com.java.base;

import java.util.List;

public class InterfaceMethodTemplate implements IMethodTemplate {
	private String methodAnnotation;
	private String methodQualifier;
	private String returnType;
	private String methodName;
	private List<ParameterTemplate> parameters;
	// #{methodAnnotation}
	// #{methodQualifier} #{returnType} #{methodName}(#{parameters} );

	public String getTemplateStr() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMethodAnnotation() {
		return methodAnnotation;
	}

	public void setMethodAnnotation(String methodAnnotation) {
		this.methodAnnotation = methodAnnotation;
	}

	public String getMethodQualifier() {
		return methodQualifier;
	}

	public void setMethodQualifier(String methodQualifier) {
		this.methodQualifier = methodQualifier;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
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

}
