package com.mantoto.product.service; 
import java.util.List;
import com.mantoto.page.Pager;

import com.mantoto.product.model.ProductType;

public interface IProductTypeService{

 public ProductType selectByIdProductType(String id ,boolean isContorller);

 public boolean deleteProductType(String id );

 public boolean updateProductType(ProductType  producttype );

 public  long insertProductType(ProductType  producttype );

 public Pager selectProductType(ProductType  producttype,boolean isContorller);

 public int selectCountProductType(ProductType  producttype,boolean isContorller );

}