package com.java.base;

import java.util.List;

public class ImplMethodTemplate extends InterfaceMethodTemplate {

	private String methodBody;

	// #{methodAnnotation}
	// #{methodQualifier} #{returnType} #{methodName}(#{parameters} ) {
	// #{methodBody}
	// }
	public String getTemplateStr() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMethodBody() {
		return methodBody;
	}

	public void setMethodBody(String methodBody) {
		this.methodBody = methodBody;
	}

}
