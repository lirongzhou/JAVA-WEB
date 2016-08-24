package com.mantoto.product.cache.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mantoto.redis.RedisBase;
import com.mantoto.page.Pager;import com.mantoto.product.model.ProductType;
import com.mantoto.product.cache.IProductTypeCache;
 
@Service
public class ProductTypecacheImpl extends RedisBase implements IProductTypeCache{
 @Override
 public  boolean updateCacheByIdProductType(String productTypeId){
return false;
}  
 @Override
 public  ProductType selectByIdProductType(String productTypeId){
return null;
}  
 @Override
 public  boolean updateCacheAllProductType(){
return false;
}  
 @Override
 public  Pager selectProductType(ProductType productType){
return null;
}  
 @Override
 public  int selectCountProductType(ProductType productType){
return 0;
}  
 @Override
 public  boolean removeProductType(String productTypeId){
return false;
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