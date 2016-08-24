package com.mantoto.product.open.service; 
import java.util.List;
import com.mantoto.page.Pager;

import com.mantoto.product.model.Coupon;

public interface ICouponOpenService{

 public Coupon selectByIdCoupon(String couponId,boolean isContorller);

 public boolean deleteCoupon(String couponId);

 public boolean updateCoupon(Coupon  coupon );

 public  long insertCoupon(Coupon  coupon );

 public Pager selectCoupon(Coupon  coupon,boolean isContorller);

 public int selectCountCoupon(Coupon  coupon,boolean isContorller );

}