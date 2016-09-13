package com.java.base;

import java.util.List;

import com.java.mantoto.mould.emun.Qualifier;

public class InterfaceMethodTemplate extends IMethodTemplate {
	private String methodAnnotation;
	private Qualifier methodQualifier;
	private String returnType;
	private String methodName;
	private List<ParameterTemplate> parameters;
	// #{methodAnnotation}
	// #{methodQualifier} #{returnType} #{methodName}(#{parameters} );

	public String getTemplateStr() {
		// TODO Auto-generated method stub
		return getTemplateStr(this);
	}

	public String getMethodAnnotation() {
		return methodAnnotation;
	}

	public void setMethodAnnotation(String methodAnnotation) {
		this.methodAnnotation = methodAnnotation;
	}

	public String getMethodQualifier() {
		if(null!=methodQualifier)
		return methodQualifier.getName();
		return null;
	}

	public void setMethodQualifier(Qualifier methodQualifier) {
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
			buffer.append(parameter.getTemplateStr().trim());

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
