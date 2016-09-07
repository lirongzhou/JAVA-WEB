package com.java.base;

public enum ClassType {

	CLASS("class"), ENUM("enum"), INTERFACE("interface"), ABSTRACT("abstract class");
	private String value;

	ClassType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
