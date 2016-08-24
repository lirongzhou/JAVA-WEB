package com.mantoto.product.contorller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.mantoto.product.model.ProductType;

public interface IProductTypeContorller {

	public ModelAndView deleteProductType(String productTypeId, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView updateProductType(ProductType producttype, ModelAndView modelAndView,
			HttpServletRequest request, HttpServletResponse response);

	public ModelAndView insertProductType(ProductType producttype, ModelAndView modelAndView,
			HttpServletRequest request, HttpServletResponse response);

	public ModelAndView selectProductType(ProductType producttype, ModelAndView modelAndView,
			HttpServletRequest request, HttpServletResponse response);

	public ModelAndView selectCountProductType(ProductType producttype, ModelAndView modelAndView,
			HttpServletRequest request, HttpServletResponse response);

	public ModelAndView selectByIdProductType(String productTypeId, ModelAndView modelAndView,
			HttpServletRequest request, HttpServletResponse response);

}