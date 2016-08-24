package com.mantoto.product.service; 
import java.util.List;
import com.mantoto.page.Pager;

import com.mantoto.product.model.Media;

public interface IMediaService{

 public Media selectByIdMedia(String id ,boolean isContorller);

 public boolean deleteMedia(String id );

 public boolean updateMedia(Media  media );

 public  long insertMedia(Media  media );

 public Pager selectMedia(Media  media,boolean isContorller);

 public int selectCountMedia(Media  media,boolean isContorller );

}