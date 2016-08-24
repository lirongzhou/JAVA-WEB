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
import com.mantoto.product.open.service.IProductOpenService;
import com.mantoto.product.model.Product;
import com.mantoto.product.contorller.IProductContorller;

@Controller
public class ProductContorller extends ControllerBase implements IProductContorller {

	@Autowired
	private IProductOpenService productOpenService;

	@RequestMapping(method = RequestMethod.GET, value = "selectCountProduct")
	@Override
	public ModelAndView selectCountProduct(Product product, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			int rowCount = productOpenService.selectCountProduct(product, true);
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

	@RequestMapping(method = RequestMethod.GET, value = "selectByIdProduct")
	@Override
	public ModelAndView selectByIdProduct(String productId, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			Product product = productOpenService.selectByIdProduct(productId, true);
			if (isReturnJson(request)) {
				String jsonStr = null;
				jsonStr = MyJsonView.serializableObject(ProductView.class, product);
				MyJsonView.sendJson(response, jsonStr);
				return null;
			} else {
				modelAndView.addObject("product", product);
				modelAndView.setViewName(getPageName(request));
				return modelAndView;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw ThrowError(request, e);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
	@Override
	public ModelAndView deleteProduct(String productId, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			boolean isSuccess = productOpenService.deleteProduct(productId);
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

	@RequestMapping(method = RequestMethod.PUT, value = "updateProduct")
	@Override
	public ModelAndView updateProduct(Product product, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			boolean isSuccess = productOpenService.updateProduct(product);
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

	@RequestMapping(method = RequestMethod.POST, value = "insertProduct")
	@Override
	public ModelAndView insertProduct(Product product, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			Long productId = productOpenService.insertProduct(product);
			if (isReturnJson(request)) {
				Map<String, String> jsonMap = new HashMap<String, String>();
				jsonMap.put("productId", productId + "");
				MyJsonView.Render(jsonMap, response);
				return null;
			} else {
				if (productId > 0)
					return returnSuccessPage(modelAndView, getSucccesTitle(request), getSuccessContent(request));
				else
					return returnErrorPage(modelAndView, getErroTitle(request), getErroContent(request));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw ThrowError(request, e);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "selectProduct")
	@Override
	public ModelAndView selectProduct(Product product, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			Pager pager = productOpenService.selectProduct(product, true);
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