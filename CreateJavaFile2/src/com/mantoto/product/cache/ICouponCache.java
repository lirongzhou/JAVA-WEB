package com.mantoto.product.cache; 

import java.util.List;
import com.mantoto.page.Pager;
import com.mantoto.cache.base.ICacheBase;
import com.mantoto.product.model.Coupon;

public interface ICouponCache  extends ICacheBase{

 public boolean  removeCoupon(String id );

 public boolean updateCacheByIdCoupon(String id );

 public Coupon selectByIdCoupon(String id );

 public boolean updateCacheAllCoupon();

 public Pager selectCoupon(Coupon  coupon );

 public int selectCountCoupon(Coupon  coupon );

}