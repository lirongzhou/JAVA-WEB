package com.mantoto.product.dao; 
import java.util.List;
import com.mantoto.product.model.Coupon;

public interface ICouponDao{

 public Coupon selectByIdCoupon(String id );

 public int deleteCoupon(String id );

 public int updateCoupon(Coupon  coupon );

 public  int insertCoupon(Coupon  coupon );

 public List<Coupon> selectCoupon(Coupon  coupon );

 public int selectCountCoupon(Coupon  coupon );

}