package com.mantoto.product.service; 
import java.util.List;
import com.mantoto.page.Pager;

import com.mantoto.product.model.UserCoupon;

public interface IUserCouponService{

 public UserCoupon selectByIdUserCoupon(String id ,boolean isContorller);

 public boolean deleteUserCoupon(String id );

 public boolean updateUserCoupon(UserCoupon  usercoupon );

 public  long insertUserCoupon(UserCoupon  usercoupon );

 public Pager selectUserCoupon(UserCoupon  usercoupon,boolean isContorller);

 public int selectCountUserCoupon(UserCoupon  usercoupon,boolean isContorller );

}