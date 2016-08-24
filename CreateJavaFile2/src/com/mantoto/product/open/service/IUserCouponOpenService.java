package com.mantoto.product.open.service; 
import java.util.List;
import com.mantoto.page.Pager;

import com.mantoto.product.model.UserCoupon;

public interface IUserCouponOpenService{

 public UserCoupon selectByIdUserCoupon(String userCouponId,boolean isContorller);

 public boolean deleteUserCoupon(String userCouponId);

 public boolean updateUserCoupon(UserCoupon  usercoupon );

 public  long insertUserCoupon(UserCoupon  usercoupon );

 public Pager selectUserCoupon(UserCoupon  usercoupon,boolean isContorller);

 public int selectCountUserCoupon(UserCoupon  usercoupon,boolean isContorller );

}