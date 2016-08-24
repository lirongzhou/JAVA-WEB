package com.mantoto.product.model;


/**
 * @author Li
 * @version 1.0
 * @created 21-八月-2016 下午 1:46:09
 */
public enum ConditionType {
	/**
	 * 等于
	 */
	EQUAL("="),
	/**
	 * 大于
	 */
	GREATER(">"),
	/**
	 * 小于
	 */
	LESS("<"),
	LIKE("like"),
	IN("in"),
	NOTIN("not in ");
	
	private String typeName;
	ConditionType(String typeName){
		this.typeName=typeName;
	}
	public String getTypeName(){
		return typeName;
	}
}