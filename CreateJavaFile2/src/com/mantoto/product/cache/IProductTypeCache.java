package com.mantoto.product.cache; 

import java.util.List;
import com.mantoto.page.Pager;
import com.mantoto.cache.base.ICacheBase;
import com.mantoto.product.model.ProductType;

public interface IProductTypeCache  extends ICacheBase{

 public boolean  removeProductType(String id );

 public boolean updateCacheByIdProductType(String id );

 public ProductType selectByIdProductType(String id );

 public boolean updateCacheAllProductType();

 public Pager selectProductType(ProductType  producttype );

 public int selectCountProductType(ProductType  producttype );

}