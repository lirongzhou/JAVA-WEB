package com.mantoto.product.model;
	/**
	* @author  作者 li rong zhou 
	* @date 创建时间：2016年8月21日 下午4:14:32 
	* 
	*  
	*/
public abstract class FilterItem {
	
	protected ConditionType conditionType;
	protected FilterType filterType;

	protected String value;

	public ConditionType getConditionType() {
		return conditionType;
	}

	public void setConditionType(ConditionType conditionType) {
		this.conditionType = conditionType;
	}

	public FilterType getFilterType() {
		return filterType;
	}

	public void setFilterType(FilterType filterType) {
		this.filterType = filterType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
