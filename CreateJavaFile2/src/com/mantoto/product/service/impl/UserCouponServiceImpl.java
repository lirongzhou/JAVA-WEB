package com.mantoto.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantoto.page.Pager;
import com.mantoto.product.cache.IUserCouponCache;
import com.mantoto.product.dao.IUserCouponDao;
import com.mantoto.product.model.UserCoupon;
import com.mantoto.product.service.IUserCouponService;
import com.mantoto.service.base.ServiceBase;

@Service
public class UserCouponServiceImpl extends ServiceBase implements IUserCouponService {

	@Autowired
	private IUserCouponDao userCouponDao;

	@Autowired
	private IUserCouponCache userCouponCache;

	@Autowired
	private Pager pager;

	@Override
	public UserCoupon selectByIdUserCoupon(String userCouponId, boolean isContorller) {
		if (super.isSelectcacheCanUse() && isContorller)
			return userCouponCache.selectByIdUserCoupon(userCouponId);
		return userCouponDao.selectByIdUserCoupon(userCouponId);
	}

	@Override
	public boolean deleteUserCoupon(String userCouponId) {
		if (userCouponDao.deleteUserCoupon(userCouponId) >= 1) {
			if (super.isCacheCanUse()) {
				userCouponCache.removeUserCoupon(userCouponId);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUserCoupon(UserCoupon userCoupon) {
		if (userCouponDao.updateUserCoupon(userCoupon) >= 1) {
			if (super.isCacheCanUse()) {
				userCouponCache.updateCacheByIdUserCoupon(userCoupon.getUserCouponId() + "");
			}
			return true;
		}
		return false;
	}

	@Override
	public long insertUserCoupon(UserCoupon userCoupon) {
		if (userCouponDao.insertUserCoupon(userCoupon) >= 1) {
			if (super.isCacheCanUse()) {
				userCouponCache.updateCacheByIdUserCoupon(userCoupon.getUserCouponId() + "");
			}
		}
		return 0;
	}

	@Override
	public Pager selectUserCoupon(UserCoupon userCoupon, boolean isContorller) {
		pager.setPageSize(userCoupon.getPageSize());
		pager.setPageNo(userCoupon.getPageNo());
		if (super.isSelectcacheCanUse() && isContorller) {
			return userCouponCache.selectUserCoupon(userCoupon);
		} else {
			pager.setRowCount(selectCountUserCoupon(userCoupon, isContorller));
			pager.setResultList(userCouponDao.selectUserCoupon(userCoupon));
		}
		return pager;
	}

	@Override
	public int selectCountUserCoupon(UserCoupon userCoupon, boolean isContorller) {
		if (super.isSelectcacheCanUse() && isContorller)
			return userCouponCache.selectCountUserCoupon(userCoupon);
		return userCouponDao.selectCountUserCoupon(userCoupon);
	}

}