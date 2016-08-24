package com.mantoto.product.cache.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mantoto.redis.RedisBase;
import com.mantoto.page.Pager;import com.mantoto.product.model.Product;
import com.mantoto.product.cache.IProductCache;
 
@Service
public class ProductcacheImpl extends RedisBase implements IProductCache{
 @Override
 public  Product selectByIdProduct(String productId){
return null;
}  
 @Override
 public  boolean updateCacheByIdProduct(String productId){
return false;
}  
 @Override
 public  boolean updateCacheAllProduct(){
return false;
}  
 @Override
 public  int selectCountProduct(Product product){
return 0;
}  
 @Override
 public  boolean removeProduct(String productId){
return false;
}  
 @Override
 public  Pager selectProduct(Product product){
return null;
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