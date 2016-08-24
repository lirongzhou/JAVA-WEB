package com.mantoto.product.model;


/**
 * @author Li
 * @version 1.0
 * @created   21-八月-2016 下午 1:46:08
 */
public class FilterProductItem extends FilterItem {

    private  FilterProductParamter paramter ;

	public FilterProductItem(){

	}
	public FilterProductParamter getParamter() {
		return paramter;
	}

	public void setParamter(FilterProductParamter paramter) {
		this.paramter = paramter;
	}

	

}