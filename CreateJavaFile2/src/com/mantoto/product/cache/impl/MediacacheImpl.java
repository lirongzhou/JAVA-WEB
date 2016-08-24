package com.mantoto.product.cache.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mantoto.redis.RedisBase;
import com.mantoto.page.Pager;import com.mantoto.product.model.Media;
import com.mantoto.product.cache.IMediaCache;
 
@Service
public class MediacacheImpl extends RedisBase implements IMediaCache{
 @Override
 public  boolean removeMedia(String mId){
return false;
}  
 @Override
 public  Pager selectMedia(Media media){
return null;
}  
 @Override
 public  boolean updateCacheByIdMedia(String mId){
return false;
}  
 @Override
 public  Media selectByIdMedia(String mId){
return null;
}  
 @Override
 public  boolean updateCacheAllMedia(){
return false;
}  
 @Override
 public  int selectCountMedia(Media media){
return 0;
}  
 @Override
 public  boolean load(){
return false;
}  
 @Override
 public  boolean clean(){
return false;
}  

}