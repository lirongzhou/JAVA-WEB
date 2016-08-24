package com.mantoto.product.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mantoto.page.Pager;
import com.mantoto.service.base.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import com.mantoto.product.dao.IMediaDao;
import com.mantoto.product.model.Media;
import com.mantoto.product.service.IMediaService;
import com.mantoto.product.cache.IMediaCache;

@Service
public class MediaServiceImpl extends ServiceBase implements IMediaService {

	@Autowired
	private IMediaDao mediaDao;

	@Autowired
	private IMediaCache mediaCache;

	@Autowired
	private Pager pager;

	@Override
	public boolean deleteMedia(String mId) {
		if (mediaDao.deleteMedia(mId) >= 1) {
			if (super.isCacheCanUse()) {
				mediaCache.removeMedia(mId);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean updateMedia(Media media) {
		if (mediaDao.updateMedia(media) >= 1) {
			if (super.isCacheCanUse()) {
				mediaCache.updateCacheByIdMedia(media.getmId() + "");
			}
			return true;
		}
		return false;
	}

	@Override
	public long insertMedia(Media media) {
		if (mediaDao.insertMedia(media) >= 1) {
			if (super.isCacheCanUse()) {
				mediaCache.updateCacheByIdMedia(media.getmId() + "");
			}
		}
		return 0;
	}

	@Override
	public Pager selectMedia(Media media, boolean isContorller) {
		pager.setPageSize(media.getPageSize());
		pager.setPageNo(media.getPageNo());
		if (super.isSelectcacheCanUse() && isContorller) {
			return mediaCache.selectMedia(media);
		} else {
			pager.setRowCount(selectCountMedia(media, isContorller));
			pager.setResultList(mediaDao.selectMedia(media));
		}
		return pager;
	}

	@Override
	public Media selectByIdMedia(String mId, boolean isContorller) {
		if (super.isSelectcacheCanUse() && isContorller)
			return mediaCache.selectByIdMedia(mId);
		return mediaDao.selectByIdMedia(mId);
	}

	@Override
	public int selectCountMedia(Media media, boolean isContorller) {
		if (super.isSelectcacheCanUse() && isContorller)
			return mediaCache.selectCountMedia(media);
		return mediaDao.selectCountMedia(media);
	}

}