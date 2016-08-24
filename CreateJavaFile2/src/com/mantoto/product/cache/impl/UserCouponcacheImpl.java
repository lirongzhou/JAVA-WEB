package com.mantoto.product.cache.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mantoto.redis.RedisBase;
import com.mantoto.page.Pager;import com.mantoto.product.model.UserCoupon;
import com.mantoto.product.cache.IUserCouponCache;
 
@Service
public class UserCouponcacheImpl extends RedisBase implements IUserCouponCache{
 @Override
 public  boolean removeUserCoupon(String userCouponId){
return false;
}  
 @Override
 public  boolean updateCacheByIdUserCoupon(String userCouponId){
return false;
}  
 @Override
 public  UserCoupon selectByIdUserCoupon(String userCouponId){
return null;
}  
 @Override
 public  boolean updateCacheAllUserCoupon(){
return false;
}  
 @Override
 public  Pager selectUserCoupon(UserCoupon userCoupon){
return null;
}  
 @Override
 public  int selectCountUserCoupon(UserCoupon userCoupon){
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