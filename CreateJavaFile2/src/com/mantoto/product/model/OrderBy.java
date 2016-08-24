package com.mantoto.product.model;


/**
 * @author Li
 * @version 1.0
 * @created 21-����-2016 ���� 1:46:12
 */
public enum OrderBy {
	
	ASC("asc"),
	DESC("desc");
	private String orderByName;
	OrderBy(String orderByName){
		this.orderByName=orderByName;
	}
	
	public String getOrderByName(){
		return orderByName;
	}
}