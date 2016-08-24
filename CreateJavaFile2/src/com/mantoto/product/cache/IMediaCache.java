package com.mantoto.product.cache; 

import java.util.List;
import com.mantoto.page.Pager;
import com.mantoto.cache.base.ICacheBase;
import com.mantoto.product.model.Media;

public interface IMediaCache  extends ICacheBase{

 public boolean  removeMedia(String id );

 public boolean updateCacheByIdMedia(String id );

 public Media selectByIdMedia(String id );

 public boolean updateCacheAllMedia();

 public Pager selectMedia(Media  media );

 public int selectCountMedia(Media  media );

}