package com.mantoto.product.service; 
import java.util.List;
import com.mantoto.page.Pager;

import com.mantoto.product.model.Product;

public interface IProductService{

 public Product selectByIdProduct(String id ,boolean isContorller);

 public boolean deleteProduct(String id );

 public boolean updateProduct(Product  product );

 public  long insertProduct(Product  product );

 public Pager selectProduct(Product  product,boolean isContorller);

 public int selectCountProduct(Product  product,boolean isContorller );

}