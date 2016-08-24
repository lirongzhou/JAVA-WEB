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
import com.mantoto.product.service.IUserCouponService;
import com.mantoto.product.model.UserCoupon;
import com.mantoto.product.open.service.IUserCouponOpenService;

@Service
public class UserCouponOpenServiceImpl extends OpenServiceBase implements IUserCouponOpenService {

	@Autowired
	private IUserCouponService userCouponService;

	@Override
	public UserCoupon selectByIdUserCoupon(String userCouponId, boolean isContorller) {
		return userCouponService.selectByIdUserCoupon(userCouponId, isContorller);
	}

	@Override
	public boolean deleteUserCoupon(String userCouponId) {
		return userCouponService.deleteUserCoupon(userCouponId);
	}

	@Override
	public boolean updateUserCoupon(UserCoupon userCoupon) {
		if (!Validate.updateSpecificationValidate(userCoupon))
			return false;
		return userCouponService.updateUserCoupon(userCoupon);
	}

	@Override
	public long insertUserCoupon(UserCoupon userCoupon) {
		userCoupon.setcTime(new Timestamp(System.currentTimeMillis()));
		userCoupon.setUserCouponId(CreateUniqId.getUniqId());
		if (!Validate.isSpecification(userCoupon))
			return 0;
		return userCouponService.insertUserCoupon(userCoupon);
	}

	@Override
	public Pager selectUserCoupon(UserCoupon userCoupon, boolean isContorller) {
		Pager pager = userCouponService.selectUserCoupon(userCoupon, isContorller);
		String strApplicationJson;
		try {
			/**
			 * 把查询条件进行序列化成为可对接的字符串
			 */
			strApplicationJson = MyJsonView.serializableObject(ProductSelectCondition.class, userCoupon);
			setPagerSelectCondition(pager, strApplicationJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pager;
	}

	@Override
	public int selectCountUserCoupon(UserCoupon userCoupon, boolean isContorller) {
		return userCouponService.selectCountUserCoupon(userCoupon, isContorller);
	}

}