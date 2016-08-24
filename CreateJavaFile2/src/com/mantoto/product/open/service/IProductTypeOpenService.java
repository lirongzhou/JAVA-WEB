package com.mantoto.product.open.service; 
import java.util.List;
import com.mantoto.page.Pager;

import com.mantoto.product.model.ProductType;

public interface IProductTypeOpenService{

 public ProductType selectByIdProductType(String productTypeId,boolean isContorller);

 public boolean deleteProductType(String productTypeId);

 public boolean updateProductType(ProductType  producttype );

 public  long insertProductType(ProductType  producttype );

 public Pager selectProductType(ProductType  producttype,boolean isContorller);

 public int selectCountProductType(ProductType  producttype,boolean isContorller );

}