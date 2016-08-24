package com.mantoto.product.open.service; 
import java.util.List;
import com.mantoto.page.Pager;

import com.mantoto.product.model.Product;

public interface IProductOpenService{

 public Product selectByIdProduct(String productId,boolean isContorller);

 public boolean deleteProduct(String productId);

 public boolean updateProduct(Product  product );

 public  long insertProduct(Product  product );

 public Pager selectProduct(Product  product,boolean isContorller);

 public int selectCountProduct(Product  product,boolean isContorller );

}