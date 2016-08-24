package com.mantoto.product.dao; 
import java.util.List;
import com.mantoto.product.model.Product;

public interface IProductDao{

 public Product selectByIdProduct(String id );

 public int deleteProduct(String id );

 public int updateProduct(Product  product );

 public  int insertProduct(Product  product );

 public List<Product> selectProduct(Product  product );

 public int selectCountProduct(Product  product );

}