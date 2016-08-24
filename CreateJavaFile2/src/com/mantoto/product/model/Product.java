package com.mantoto.product.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.mantoto.annotation.ValidateAnnotaion;
import com.mantoto.annotation.ValidateAnnotaion.CanUpdate;
import com.mantoto.annotation.ValidateAnnotaion.IsId;
import com.mantoto.base.bean.BeanBase;
import com.mantoto.product.jsonView.ProductView;
import com.mantoto.util.MyJsonView;

public class Product extends BeanBase {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private String descripation;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private int integral;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private boolean isForExpress;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private String keyWords;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private int stock;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private int saleAs;

	@JsonView(ProductView.class)
	@ValidateAnnotaion(isId = IsId.TRUE)
	private long productId;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private short status;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private String detailJson;
    
	private List<ProductParameter> parameterList;
	
	@JsonView(ProductView.class)
	@ValidateAnnotaion(canUpdate = CanUpdate.FALSE)
	private long businessId;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private Timestamp eTime;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private BigDecimal price;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private long frontCoverId;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private long productTypeId;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private String productName;

	@JsonView(ProductView.class)
	@ValidateAnnotaion(canUpdate = CanUpdate.FALSE)
	private Timestamp cTime;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private long editBy;
	
	@JsonView(ProductView.class)
	private ProductType productType;
	
	@JsonView(ProductView.class)
	private Media media;
	
	public String getDescripation() {
		return descripation;
	}

	public void setDescripation(String descripation) {
		this.descripation = descripation;
	}

	public int getIntegral() {
		return integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

	public boolean isForExpress() {
		return isForExpress;
	}

	public void setForExpress(boolean isForExpress) {
		this.isForExpress = isForExpress;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getSaleAs() {
		return saleAs;
	}

	public void setSaleAs(int saleAs) {
		this.saleAs = saleAs;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getDetailJson() throws Exception {
		if( isNull(parameterList))
		return detailJson;
		else 
			return MyJsonView.serializableObject(parameterList);
	}

	public void setDetailJson(String detailJson)  throws Exception{
		if(isNull(detailJson))
			parameterList=(List<ProductParameter>) MyJsonView.deserializationList(detailJson, List.class);
		this.detailJson = detailJson;
	}

	public long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(long businessId) {
		this.businessId = businessId;
	}

	public Timestamp geteTime() {
		return eTime;
	}

	public void seteTime(Timestamp eTime) {
		this.eTime = eTime;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public long getFrontCoverId() {
		return frontCoverId;
	}

	public void setFrontCoverId(long frontCoverId) {
		this.frontCoverId = frontCoverId;
	}

	public long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Timestamp getcTime() {
		return cTime;
	}

	public void setcTime(Timestamp cTime) {
		this.cTime = cTime;
	}

	public long getEditBy() {
		return editBy;
	}

	public void setEditBy(long editBy) {
		this.editBy = editBy;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public List<ProductParameter> getParameterList() {
		return parameterList;
	}

	public void setParameterList(List<ProductParameter> parameterList) {
		this.parameterList = parameterList;
	}

}