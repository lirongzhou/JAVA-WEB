package com.mantoto.product.dao; 
import java.util.List;
import com.mantoto.product.model.Media;

public interface IMediaDao{

 public Media selectByIdMedia(String id );

 public int deleteMedia(String id );

 public int updateMedia(Media  media );

 public  int insertMedia(Media  media );

 public List<Media> selectMedia(Media  media );

 public int selectCountMedia(Media  media );

}