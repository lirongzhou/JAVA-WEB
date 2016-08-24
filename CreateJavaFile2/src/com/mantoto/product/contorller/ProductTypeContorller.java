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
import com.mantoto.product.open.service.IProductTypeOpenService;
import com.mantoto.product.model.ProductType;
import com.mantoto.product.contorller.IProductTypeContorller;

@Controller
public class ProductTypeContorller extends ControllerBase implements IProductTypeContorller {

	@Autowired
	private IProductTypeOpenService productTypeOpenService;

	@RequestMapping(method = RequestMethod.DELETE, value = "deleteProductType")
	@Override
	public ModelAndView deleteProductType(String productTypeId, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			boolean isSuccess = productTypeOpenService.deleteProductType(productTypeId);
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

	@RequestMapping(method = RequestMethod.PUT, value = "updateProductType")
	@Override
	public ModelAndView updateProductType(ProductType productType, ModelAndView modelAndView,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			boolean isSuccess = productTypeOpenService.updateProductType(productType);
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

	@RequestMapping(method = RequestMethod.POST, value = "insertProductType")
	@Override
	public ModelAndView insertProductType(ProductType productType, ModelAndView modelAndView,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			Long productTypeId = productTypeOpenService.insertProductType(productType);
			if (isReturnJson(request)) {
				Map<String, String> jsonMap = new HashMap<String, String>();
				jsonMap.put("productTypeId", productTypeId + "");
				MyJsonView.Render(jsonMap, response);
				return null;
			} else {
				if (productTypeId > 0)
					return returnSuccessPage(modelAndView, getSucccesTitle(request), getSuccessContent(request));
				else
					return returnErrorPage(modelAndView, getErroTitle(request), getErroContent(request));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw ThrowError(request, e);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "selectProductType")
	@Override
	public ModelAndView selectProductType(ProductType productType, ModelAndView modelAndView,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			Pager pager = productTypeOpenService.selectProductType(productType, true);
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

	@RequestMapping(method = RequestMethod.GET, value = "selectCountProductType")
	@Override
	public ModelAndView selectCountProductType(ProductType productType, ModelAndView modelAndView,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			int rowCount = productTypeOpenService.selectCountProductType(productType, true);
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

	@RequestMapping(method = RequestMethod.GET, value = "selectByIdProductType")
	@Override
	public ModelAndView selectByIdProductType(String productTypeId, ModelAndView modelAndView,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			ProductType productType = productTypeOpenService.selectByIdProductType(productTypeId, true);
			if (isReturnJson(request)) {
				String jsonStr = null;
				jsonStr = MyJsonView.serializableObject(ProductView.class, productType);
				MyJsonView.sendJson(response, jsonStr);
				return null;
			} else {
				modelAndView.addObject("productType", productType);
				modelAndView.setViewName(getPageName(request));
				return modelAndView;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw ThrowError(request, e);
		}
	}

}