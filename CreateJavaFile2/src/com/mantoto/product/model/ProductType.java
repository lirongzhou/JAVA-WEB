package com.mantoto.product.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.mantoto.annotation.ValidateAnnotaion;
import com.mantoto.annotation.ValidateAnnotaion.IsId;
import com.mantoto.base.bean.BeanBase;
import com.mantoto.product.jsonView.ProductView;
import com.mantoto.util.MyJsonView;

public class ProductType extends BeanBase {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private boolean isValid;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private String paramterJson;

	
	private List<ProductTypeParamter> paramterList;
	
	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private long rootId;

	@JsonView(ProductView.class)
	@ValidateAnnotaion(isId = IsId.TRUE)
	private long productTypeId;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private String productTypeName;

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getParamterJson() throws Exception {
		if(isNull(paramterList))
		return paramterJson;
		else 
			return MyJsonView.serializableObject(paramterList);
	}

	public void setParamterJson(String paramterJson)  throws Exception{
		if(!isNull(paramterJson)){
			paramterList=(List<ProductTypeParamter>) MyJsonView.deserializationList(paramterJson, List.class);
		}
		this.paramterJson = paramterJson;
	}

	public long getRootId() {
		return rootId;
	}

	public void setRootId(long rootId) {
		this.rootId = rootId;
	}

	public long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public List<ProductTypeParamter> getParamterList() {
		return paramterList;
	}

	public void setParamterList(List<ProductTypeParamter> paramterList) {
		this.paramterList = paramterList;
	}

}