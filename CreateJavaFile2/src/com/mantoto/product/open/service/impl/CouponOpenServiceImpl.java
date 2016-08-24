package com.mantoto.product.open.service.impl;

import java.util.List;
import com.mantoto.page.Pager;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import com.mantoto.util.MyJsonView;
import com.mantoto.util.Validate;
import com.mantoto.util.CreateUniqId;
import com.mantoto.open.service.base.OpenServiceBase;
import com.mantoto.product.jsonView.ProductSelectCondition;
import org.springframework.beans.factory.annotation.Autowired;
import com.mantoto.product.service.ICouponService;
import com.mantoto.product.model.Coupon;
import com.mantoto.product.open.service.ICouponOpenService;

@Service
public class CouponOpenServiceImpl extends OpenServiceBase implements ICouponOpenService {

	@Autowired
	private ICouponService couponService;

	@Override
	public boolean deleteCoupon(String couponId) {
		return couponService.deleteCoupon(couponId);
	}

	@Override
	public boolean updateCoupon(Coupon coupon) {
		if (!Validate.updateSpecificationValidate(coupon))
			return false;
		return couponService.updateCoupon(coupon);
	}

	@Override
	public long insertCoupon(Coupon coupon) {
		coupon.setcTime(new Timestamp(System.currentTimeMillis()));
		coupon.setCouponId(CreateUniqId.getUniqId());
		if (!Validate.isSpecification(coupon))
			return 0;
		return couponService.insertCoupon(coupon);
	}

	@Override
	public Pager selectCoupon(Coupon coupon, boolean isContorller) {
		Pager pager = couponService.selectCoupon(coupon, isContorller);
		String strApplicationJson;
		try {
			/**
			 * 把查询条件进行序列化成为可对接的字符串
			 */
			strApplicationJson = MyJsonView.serializableObject(ProductSelectCondition.class, coupon);
			setPagerSelectCondition(pager, strApplicationJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pager;
	}

	@Override
	public Coupon selectByIdCoupon(String couponId, boolean isContorller) {
		return couponService.selectByIdCoupon(couponId, isContorller);
	}

	@Override
	public int selectCountCoupon(Coupon coupon, boolean isContorller) {
		return couponService.selectCountCoupon(coupon, isContorller);
	}

}