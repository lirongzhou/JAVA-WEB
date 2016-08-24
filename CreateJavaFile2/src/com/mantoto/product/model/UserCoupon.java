package com.mantoto.product.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonView;
import com.mantoto.annotation.ValidateAnnotaion;
import com.mantoto.annotation.ValidateAnnotaion.CanUpdate;
import com.mantoto.annotation.ValidateAnnotaion.IsId;
import com.mantoto.base.bean.BeanBase;
import com.mantoto.product.jsonView.ProductView;

public class UserCoupon extends BeanBase {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private int source;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private int status;

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Timestamp getcTime() {
		return cTime;
	}

	public void setcTime(Timestamp cTime) {
		this.cTime = cTime;
	}

	public long getUserCouponId() {
		return userCouponId;
	}

	public void setUserCouponId(long userCouponId) {
		this.userCouponId = userCouponId;
	}

	public long getUseIn() {
		return useIn;
	}

	public void setUseIn(long useIn) {
		this.useIn = useIn;
	}

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private Timestamp bTime;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private Timestamp eTime;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private long couponId;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private String mobile;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private long userId;

	@JsonView(ProductView.class)
	@ValidateAnnotaion(canUpdate = CanUpdate.FALSE)
	private Timestamp cTime;

	@JsonView(ProductView.class)
	@ValidateAnnotaion(isId = IsId.TRUE)
	private long userCouponId;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private long useIn;

}