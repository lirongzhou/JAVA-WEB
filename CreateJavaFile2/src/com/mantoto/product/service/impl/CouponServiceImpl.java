package com.mantoto.product.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mantoto.page.Pager;
import com.mantoto.service.base.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import com.mantoto.product.dao.ICouponDao;
import com.mantoto.product.model.Coupon;
import com.mantoto.product.service.ICouponService;
import com.mantoto.product.cache.ICouponCache;

@Service
public class CouponServiceImpl extends ServiceBase implements ICouponService {

	@Autowired
	private ICouponDao couponDao;

	@Autowired
	private ICouponCache couponCache;

	@Autowired
	private Pager pager;

	@Override
	public boolean deleteCoupon(String couponId) {
		if (couponDao.deleteCoupon(couponId) >= 1) {
			if (super.isCacheCanUse()) {
				couponCache.removeCoupon(couponId);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCoupon(Coupon coupon) {
		if (couponDao.updateCoupon(coupon) >= 1) {
			if (super.isCacheCanUse()) {
				couponCache.updateCacheByIdCoupon(coupon.getCouponId() + "");
			}
			return true;
		}
		return false;
	}

	@Override
	public long insertCoupon(Coupon coupon) {
		if (couponDao.insertCoupon(coupon) >= 1) {
			if (super.isCacheCanUse()) {
				couponCache.updateCacheByIdCoupon(coupon.getCouponId() + "");
			}
		}
		return 0;
	}

	@Override
	public Pager selectCoupon(Coupon coupon, boolean isContorller) {
		pager.setPageSize(coupon.getPageSize());
		pager.setPageNo(coupon.getPageNo());
		if (super.isSelectcacheCanUse() && isContorller) {
			return couponCache.selectCoupon(coupon);
		} else {
			pager.setRowCount(selectCountCoupon(coupon, isContorller));
			pager.setResultList(couponDao.selectCoupon(coupon));
		}
		return pager;
	}

	@Override
	public Coupon selectByIdCoupon(String couponId, boolean isContorller) {
		if (super.isSelectcacheCanUse() && isContorller)
			return couponCache.selectByIdCoupon(couponId);
		return couponDao.selectByIdCoupon(couponId);
	}

	@Override
	public int selectCountCoupon(Coupon coupon, boolean isContorller) {
		if (super.isSelectcacheCanUse() && isContorller)
			return couponCache.selectCountCoupon(coupon);
		return couponDao.selectCountCoupon(coupon);
	}

}