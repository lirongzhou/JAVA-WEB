package com.mantoto.product.contorller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.mantoto.product.model.Product;

public interface IProductContorller {

	public ModelAndView deleteProduct(String productId, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView updateProduct(Product product, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView insertProduct(Product product, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView selectProduct(Product product, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView selectCountProduct(Product product, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView selectByIdProduct(String productId, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

}