package com.mantoto.product.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.mantoto.product.jsonView.ProductView;

/**
	* @author  作者 li rong zhou 
	* @date 创建时间：2016年8月21日 下午3:58:09 
	* 
	*  
	*/
public class ProductParameter {
	
	
	private ProductTypeParamter productTypeParamter ;
	
	private String value;
	
	
	public ProductTypeParamter getProductTypeParamter() {
		return productTypeParamter;
	}
	public void setProductTypeParamter(ProductTypeParamter productTypeParamter) {
		this.productTypeParamter = productTypeParamter;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
