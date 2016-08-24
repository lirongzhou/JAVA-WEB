package com.mantoto.product.open.service.impl;

import java.util.List;
import com.mantoto.page.Pager;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import com.mantoto.util.MyJsonView;
import com.mantoto.util.Validate;
import com.mantoto.util.CreateUniqId;
import com.mantoto.open.service.base.OpenServiceBase;
import com.mantoto.product.jsonView.ProductSelectCondition;
import org.springframework.beans.factory.annotation.Autowired;
import com.mantoto.product.service.IMediaService;
import com.mantoto.product.model.Media;
import com.mantoto.product.open.service.IMediaOpenService;

@Service
public class MediaOpenServiceImpl extends OpenServiceBase implements IMediaOpenService {

	@Autowired
	private IMediaService mediaService;

	@Override
	public boolean deleteMedia(String mId) {
		return mediaService.deleteMedia(mId);
	}

	@Override
	public boolean updateMedia(Media media) {
		if (!Validate.updateSpecificationValidate(media))
			return false;
		return mediaService.updateMedia(media);
	}

	@Override
	public long insertMedia(Media media) {
		media.setmId(CreateUniqId.getUniqId());
		if (!Validate.isSpecification(media))
			return 0;
		return mediaService.insertMedia(media);
	}

	@Override
	public Pager selectMedia(Media media, boolean isContorller) {
		Pager pager = mediaService.selectMedia(media, isContorller);
		String strApplicationJson;
		try {
			/**
			 * 把查询条件进行序列化成为可对接的字符串
			 */
			strApplicationJson = MyJsonView.serializableObject(ProductSelectCondition.class, media);
			setPagerSelectCondition(pager, strApplicationJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pager;
	}

	@Override
	public Media selectByIdMedia(String mId, boolean isContorller) {
		return mediaService.selectByIdMedia(mId, isContorller);
	}

	@Override
	public int selectCountMedia(Media media, boolean isContorller) {
		return mediaService.selectCountMedia(media, isContorller);
	}

}