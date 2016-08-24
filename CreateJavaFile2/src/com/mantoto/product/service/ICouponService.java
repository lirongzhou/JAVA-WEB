package com.mantoto.product.service; 
import java.util.List;
import com.mantoto.page.Pager;

import com.mantoto.product.model.Coupon;

public interface ICouponService{

 public Coupon selectByIdCoupon(String id ,boolean isContorller);

 public boolean deleteCoupon(String id );

 public boolean updateCoupon(Coupon  coupon );

 public  long insertCoupon(Coupon  coupon );

 public Pager selectCoupon(Coupon  coupon,boolean isContorller);

 public int selectCountCoupon(Coupon  coupon,boolean isContorller );

}