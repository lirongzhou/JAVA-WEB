package com.mantoto.product.contorller;

import java.util.List;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;
import com.mantoto.page.Pager;
import com.mantoto.controller.base.ControllerBase;
import com.mantoto.product.jsonView.ProductView;
import com.mantoto.util.MyJsonView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mantoto.product.open.service.ICouponOpenService;
import com.mantoto.product.model.Coupon;
import com.mantoto.product.contorller.ICouponContorller;

@Controller
public class CouponContorller extends ControllerBase implements ICouponContorller {

	@Autowired
	private ICouponOpenService couponOpenService;

	@RequestMapping(method = RequestMethod.GET, value = "selectCountCoupon")
	@Override
	public ModelAndView selectCountCoupon(Coupon coupon, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			int rowCount = couponOpenService.selectCountCoupon(coupon, true);
			if (isReturnJson(request)) {
				Map<String, String> jsonMap = new HashMap<String, String>();
				jsonMap.put("rowCount", rowCount + "");
				MyJsonView.Render(jsonMap, response);
				return null;
			}
			modelAndView.addObject("rowCount", rowCount);
			modelAndView.setViewName(getPageName(request));
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			throw ThrowError(request, e);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "selectByIdCoupon")
	@Override
	public ModelAndView selectByIdCoupon(String couponId, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			Coupon coupon = couponOpenService.selectByIdCoupon(couponId, true);
			if (isReturnJson(request)) {
				String jsonStr = null;
				jsonStr = MyJsonView.serializableObject(ProductView.class, coupon);
				MyJsonView.sendJson(response, jsonStr);
				return null;
			} else {
				modelAndView.addObject("coupon", coupon);
				modelAndView.setViewName(getPageName(request));
				return modelAndView;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw ThrowError(request, e);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "deleteCoupon")
	@Override
	public ModelAndView deleteCoupon(String couponId, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			boolean isSuccess = couponOpenService.deleteCoupon(couponId);
			if (isReturnJson(request)) {
				Map<String, String> jsonMap = new HashMap<String, String>();
				jsonMap.put("isSuccess", isSuccess ? "true" : "false");
				MyJsonView.Render(jsonMap, response);
				return null;
			} else {
				if (isSuccess)
					return returnSuccessPage(modelAndView, getSucccesTitle(request), getSuccessContent(request));
				else
					return returnErrorPage(modelAndView, getErroTitle(request), getErroContent(request));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw ThrowError(request, e);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "updateCoupon")
	@Override
	public ModelAndView updateCoupon(Coupon coupon, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			boolean isSuccess = couponOpenService.updateCoupon(coupon);
			if (isReturnJson(request)) {
				Map<String, String> jsonMap = new HashMap<String, String>();
				jsonMap.put("isSuccess", isSuccess ? "true" : "false");
				MyJsonView.Render(jsonMap, response);
				return null;
			} else {
				if (isSuccess)
					return returnSuccessPage(modelAndView, getSucccesTitle(request), getSuccessContent(request));
				else
					return returnErrorPage(modelAndView, getErroTitle(request), getErroContent(request));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw ThrowError(request, e);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "insertCoupon")
	@Override
	public ModelAndView insertCoupon(Coupon coupon, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			Long couponId = couponOpenService.insertCoupon(coupon);
			if (isReturnJson(request)) {
				Map<String, String> jsonMap = new HashMap<String, String>();
				jsonMap.put("couponId", couponId + "");
				MyJsonView.Render(jsonMap, response);
				return null;
			} else {
				if (couponId > 0)
					return returnSuccessPage(modelAndView, getSucccesTitle(request), getSuccessContent(request));
				else
					return returnErrorPage(modelAndView, getErroTitle(request), getErroContent(request));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw ThrowError(request, e);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "selectCoupon")
	@Override
	public ModelAndView selectCoupon(Coupon coupon, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			Pager pager = couponOpenService.selectCoupon(coupon, true);
			if (isReturnJson(request)) {
				String jsonStr = null;
				jsonStr = MyJsonView.serializableObject(ProductView.class, pager);
				MyJsonView.sendJson(response, jsonStr);
				return null;
			} else {
				modelAndView.addObject("pager", pager);
				modelAndView.setViewName(getPageName(request));
				return modelAndView;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw ThrowError(request, e);
		}
	}

}