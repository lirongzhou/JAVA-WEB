package com.mantoto.product.cache; 

import java.util.List;
import com.mantoto.page.Pager;
import com.mantoto.cache.base.ICacheBase;
import com.mantoto.product.model.Product;

public interface IProductCache  extends ICacheBase{

 public boolean  removeProduct(String id );

 public boolean updateCacheByIdProduct(String id );

 public Product selectByIdProduct(String id );

 public boolean updateCacheAllProduct();

 public Pager selectProduct(Product  product );

 public int selectCountProduct(Product  product );

}