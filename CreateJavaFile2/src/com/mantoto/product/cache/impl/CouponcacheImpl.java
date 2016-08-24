package com.mantoto.product.cache.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mantoto.redis.RedisBase;
import com.mantoto.page.Pager;import com.mantoto.product.model.Coupon;
import com.mantoto.product.cache.ICouponCache;
 
@Service
public class CouponcacheImpl extends RedisBase implements ICouponCache{
 @Override
 public  boolean updateCacheByIdCoupon(String couponId){
return false;
}  
 @Override
 public  Coupon selectByIdCoupon(String couponId){
return null;
}  
 @Override
 public  boolean updateCacheAllCoupon(){
return false;
}  
 @Override
 public  boolean removeCoupon(String couponId){
return false;
}  
 @Override
 public  Pager selectCoupon(Coupon coupon){
return null;
}  
 @Override
 public  int selectCountCoupon(Coupon coupon){
return 0;
}  
 @Override
 public  boolean load(){
return false;
}  
 @Override
 public  boolean clean(){
return false;
}  

}