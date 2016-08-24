package com.mantoto.product.cache; 

import java.util.List;
import com.mantoto.page.Pager;
import com.mantoto.cache.base.ICacheBase;
import com.mantoto.product.model.UserCoupon;

public interface IUserCouponCache  extends ICacheBase{

 public boolean  removeUserCoupon(String id );

 public boolean updateCacheByIdUserCoupon(String id );

 public UserCoupon selectByIdUserCoupon(String id );

 public boolean updateCacheAllUserCoupon();

 public Pager selectUserCoupon(UserCoupon  usercoupon );

 public int selectCountUserCoupon(UserCoupon  usercoupon );

}