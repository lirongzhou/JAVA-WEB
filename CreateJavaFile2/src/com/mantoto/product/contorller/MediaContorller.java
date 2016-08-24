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
import com.mantoto.product.open.service.IMediaOpenService;
import com.mantoto.product.model.Media;
import com.mantoto.product.contorller.IMediaContorller;

@Controller
public class MediaContorller extends ControllerBase implements IMediaContorller {

	@Autowired
	private IMediaOpenService mediaOpenService;

	@RequestMapping(method = RequestMethod.GET, value = "selectCountMedia")
	@Override
	public ModelAndView selectCountMedia(Media media, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			int rowCount = mediaOpenService.selectCountMedia(media, true);
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

	@RequestMapping(method = RequestMethod.GET, value = "selectByIdMedia")
	@Override
	public ModelAndView selectByIdMedia(String mId, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			Media media = mediaOpenService.selectByIdMedia(mId, true);
			if (isReturnJson(request)) {
				String jsonStr = null;
				jsonStr = MyJsonView.serializableObject(ProductView.class, media);
				MyJsonView.sendJson(response, jsonStr);
				return null;
			} else {
				modelAndView.addObject("media", media);
				modelAndView.setViewName(getPageName(request));
				return modelAndView;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw ThrowError(request, e);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "deleteMedia")
	@Override
	public ModelAndView deleteMedia(String mId, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			boolean isSuccess = mediaOpenService.deleteMedia(mId);
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

	@RequestMapping(method = RequestMethod.PUT, value = "updateMedia")
	@Override
	public ModelAndView updateMedia(Media media, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			boolean isSuccess = mediaOpenService.updateMedia(media);
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

	@RequestMapping(method = RequestMethod.POST, value = "insertMedia")
	@Override
	public ModelAndView insertMedia(Media media, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			Long mId = mediaOpenService.insertMedia(media);
			if (isReturnJson(request)) {
				Map<String, String> jsonMap = new HashMap<String, String>();
				jsonMap.put("mId", mId + "");
				MyJsonView.Render(jsonMap, response);
				return null;
			} else {
				if (mId > 0)
					return returnSuccessPage(modelAndView, getSucccesTitle(request), getSuccessContent(request));
				else
					return returnErrorPage(modelAndView, getErroTitle(request), getErroContent(request));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw ThrowError(request, e);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "selectMedia")
	@Override
	public ModelAndView selectMedia(Media media, ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			Pager pager = mediaOpenService.selectMedia(media, true);
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