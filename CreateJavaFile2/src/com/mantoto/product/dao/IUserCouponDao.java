package com.mantoto.product.dao; 
import java.util.List;
import com.mantoto.product.model.UserCoupon;

public interface IUserCouponDao{

 public UserCoupon selectByIdUserCoupon(String id );

 public int deleteUserCoupon(String id );

 public int updateUserCoupon(UserCoupon  usercoupon );

 public  int insertUserCoupon(UserCoupon  usercoupon );

 public List<UserCoupon> selectUserCoupon(UserCoupon  usercoupon );

 public int selectCountUserCoupon(UserCoupon  usercoupon );

}