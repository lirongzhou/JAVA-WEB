package com.mantoto.product.open.service; 
import java.util.List;
import com.mantoto.page.Pager;

import com.mantoto.product.model.Media;

public interface IMediaOpenService{

 public Media selectByIdMedia(String mId,boolean isContorller);

 public boolean deleteMedia(String mId);

 public boolean updateMedia(Media  media );

 public  long insertMedia(Media  media );

 public Pager selectMedia(Media  media,boolean isContorller);

 public int selectCountMedia(Media  media,boolean isContorller );

}