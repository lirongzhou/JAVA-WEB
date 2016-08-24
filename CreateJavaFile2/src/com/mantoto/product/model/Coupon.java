package com.mantoto.product.model;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.mantoto.annotation.ValidateAnnotaion;
import com.mantoto.annotation.ValidateAnnotaion.CanUpdate;
import com.mantoto.annotation.ValidateAnnotaion.IsId;
import com.mantoto.base.bean.BeanBase;
import com.mantoto.product.jsonView.ProductView;
import com.mantoto.util.MyJsonView;

public class Coupon extends BeanBase {

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private Timestamp bTime;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private Timestamp eTime;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@JsonView(ProductView.class)
	@ValidateAnnotaion(isId = IsId.TRUE)
	private long couponId;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private String instruction;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private String filterJson;

	private List< FilterProductItem >filterItemList;
	
	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private Timestamp cTime;

	@JsonView(ProductView.class)
	@ValidateAnnotaion(canUpdate = CanUpdate.FALSE)
	private long productId;

	@JsonView(ProductView.class)
	private Product product;
	
	public Timestamp getbTime() {
		return bTime;
	}

	public void setbTime(Timestamp bTime) {
		this.bTime = bTime;
	}

	public Timestamp geteTime() {
		return eTime;
	}

	public void seteTime(Timestamp eTime) {
		this.eTime = eTime;
	}

	public long getCouponId() {
		return couponId;
	}

	public void setCouponId(long couponId) {
		this.couponId = couponId;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getFilterJson() throws Exception {
		if(isNull(filterItemList))
		return filterJson;
		else return  MyJsonView.serializableObject(filterItemList);
	}

	public void setFilterJson(String filterJson)  throws Exception{
		if(isNull(filterJson)){
			return ;
		}
		filterItemList=(List<FilterProductItem>) MyJsonView.deserializationList(filterJson, List.class);
		this.filterJson = filterJson;
	}

	public Timestamp getcTime() {
		return cTime;
	}

	public void setcTime(Timestamp cTime) {
		this.cTime = cTime;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public List<FilterProductItem> getFilterItemList() {
		return filterItemList;
	}

	public void setFilterItemList(List<FilterProductItem> filterItemList) {
		this.filterItemList = filterItemList;
	}

	

}