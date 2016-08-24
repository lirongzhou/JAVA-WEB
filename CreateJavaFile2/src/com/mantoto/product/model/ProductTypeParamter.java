package com.mantoto.product.model;
/**
 * @author Li
 * @version 1.0
 * @created 21-八月-2016 下午 1:46:07
 */
public class ProductTypeParamter {
	
	private DataType dataType;

	private String keyName;

	private ParamterGroup paramterGroup;
	/**
	 * 显示级别
	 */
	private int priority;

	public ProductTypeParamter(){

	}

	public String getKeyName() {
		return keyName;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public ParamterGroup getParamterGroup() {
		return paramterGroup;
	}

	public void setParamterGroup(ParamterGroup paramterGroup) {
		this.paramterGroup = paramterGroup;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}