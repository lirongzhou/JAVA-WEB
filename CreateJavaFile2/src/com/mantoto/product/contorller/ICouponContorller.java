package com.mantoto.product.contorller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.mantoto.product.model.Coupon;

public interface ICouponContorller {

	public ModelAndView deleteCoupon(String couponId, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView updateCoupon(Coupon coupon, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView insertCoupon(Coupon coupon, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView selectCoupon(Coupon coupon, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView selectCountCoupon(Coupon coupon, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView selectByIdCoupon(String couponId, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

}