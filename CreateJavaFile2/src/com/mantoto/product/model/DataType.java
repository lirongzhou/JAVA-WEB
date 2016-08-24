package com.mantoto.product.model;


/**
 * @author Li
 * @version 1.0
 * @created 21-八月-2016 下午 1:46:08
 */
public enum DataType {
	STING("String"),
	INT("int"),
	LONG("long"),
	FLOAT("float"),
	DOUBLE("double"),
	BOOLEAN("boolean"),
	DATETIME("Timestamp");
	private String typeName;
	DataType(String typeName){
		this.typeName=typeName;
	}
	
	public String getTypeName(){
		return typeName;
	}
}