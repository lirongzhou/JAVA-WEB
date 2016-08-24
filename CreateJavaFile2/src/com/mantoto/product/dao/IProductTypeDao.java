package com.mantoto.product.dao; 
import java.util.List;
import com.mantoto.product.model.ProductType;

public interface IProductTypeDao{

 public ProductType selectByIdProductType(String id );

 public int deleteProductType(String id );

 public int updateProductType(ProductType  producttype );

 public  int insertProductType(ProductType  producttype );

 public List<ProductType> selectProductType(ProductType  producttype );

 public int selectCountProductType(ProductType  producttype );

}