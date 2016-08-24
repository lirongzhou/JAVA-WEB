package com.mantoto.product.contorller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.mantoto.product.model.UserCoupon;

public interface IUserCouponContorller {

	public ModelAndView deleteUserCoupon(String userCouponId, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView updateUserCoupon(UserCoupon usercoupon, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView insertUserCoupon(UserCoupon usercoupon, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView selectUserCoupon(UserCoupon usercoupon, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView selectCountUserCoupon(UserCoupon usercoupon, ModelAndView modelAndView,
			HttpServletRequest request, HttpServletResponse response);

	public ModelAndView selectByIdUserCoupon(String userCouponId, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

}