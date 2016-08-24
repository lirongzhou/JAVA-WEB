package com.mantoto.product.contorller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.mantoto.product.model.Media;

public interface IMediaContorller {

	public ModelAndView deleteMedia(String mId, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView updateMedia(Media media, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView insertMedia(Media media, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView selectMedia(Media media, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView selectCountMedia(Media media, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView selectByIdMedia(String mId, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response);

}