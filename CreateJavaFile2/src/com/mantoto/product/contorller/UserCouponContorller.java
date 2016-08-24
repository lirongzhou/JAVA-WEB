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
import com.mantoto.product.open.service.IUserCouponOpenService;
import com.mantoto.product.model.UserCoupon;
import com.mantoto.product.contorller.IUserCouponContorller;

@Controller
public class UserCouponContorller extends ControllerBase implements IUserCouponContorller {

	@Autowired
	private IUserCouponOpenService userCouponOpenService;

	@RequestMapping(method = RequestMethod.DELETE, value = "deleteUserCoupon")
	@Override
	public ModelAndView deleteUserCoupon(String userCouponId, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			boolean isSuccess = userCouponOpenService.deleteUserCoupon(userCouponId);
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

	@RequestMapping(method = RequestMethod.PUT, value = "updateUserCoupon")
	@Override
	public ModelAndView updateUserCoupon(UserCoupon userCoupon, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			boolean isSuccess = userCouponOpenService.updateUserCoupon(userCoupon);
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

	@RequestMapping(method = RequestMethod.POST, value = "insertUserCoupon")
	@Override
	public ModelAndView insertUserCoupon(UserCoupon userCoupon, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			Long userCouponId = userCouponOpenService.insertUserCoupon(userCoupon);
			if (isReturnJson(request)) {
				Map<String, String> jsonMap = new HashMap<String, String>();
				jsonMap.put("userCouponId", userCouponId + "");
				MyJsonView.Render(jsonMap, response);
				return null;
			} else {
				if (userCouponId > 0)
					return returnSuccessPage(modelAndView, getSucccesTitle(request), getSuccessContent(request));
				else
					return returnErrorPage(modelAndView, getErroTitle(request), getErroContent(request));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw ThrowError(request, e);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "selectUserCoupon")
	@Override
	public ModelAndView selectUserCoupon(UserCoupon userCoupon, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			Pager pager = userCouponOpenService.selectUserCoupon(userCoupon, true);
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

	@RequestMapping(method = RequestMethod.GET, value = "selectCountUserCoupon")
	@Override
	public ModelAndView selectCountUserCoupon(UserCoupon userCoupon, ModelAndView modelAndView,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			int rowCount = userCouponOpenService.selectCountUserCoupon(userCoupon, true);
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

	@RequestMapping(method = RequestMethod.GET, value = "selectByIdUserCoupon")
	@Override
	public ModelAndView selectByIdUserCoupon(String userCouponId, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			UserCoupon userCoupon = userCouponOpenService.selectByIdUserCoupon(userCouponId, true);
			if (isReturnJson(request)) {
				String jsonStr = null;
				jsonStr = MyJsonView.serializableObject(ProductView.class, userCoupon);
				MyJsonView.sendJson(response, jsonStr);
				return null;
			} else {
				modelAndView.addObject("userCoupon", userCoupon);
				modelAndView.setViewName(getPageName(request));
				return modelAndView;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw ThrowError(request, e);
		}
	}

}