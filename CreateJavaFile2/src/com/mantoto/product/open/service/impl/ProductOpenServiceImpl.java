package com.mantoto.product.open.service.impl;

import java.util.List;
import com.mantoto.page.Pager;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import com.mantoto.util.MyJsonView;
import com.mantoto.util.Validate;
import com.mantoto.util.CreateUniqId;
import com.mantoto.open.service.base.OpenServiceBase;
import com.mantoto.product.jsonView.ProductSelectCondition;
import org.springframework.beans.factory.annotation.Autowired;
import com.mantoto.product.service.IProductService;
import com.mantoto.product.model.Product;
import com.mantoto.product.open.service.IProductOpenService;

@Service
public class ProductOpenServiceImpl extends OpenServiceBase implements IProductOpenService {

	@Autowired
	private IProductService productService;

	@Override
	public boolean deleteProduct(String productId) {
		return productService.deleteProduct(productId);
	}

	@Override
	public boolean updateProduct(Product product) {
		if (!Validate.updateSpecificationValidate(product))
			return false;
		return productService.updateProduct(product);
	}

	@Override
	public long insertProduct(Product product) {
		product.setcTime(new Timestamp(System.currentTimeMillis()));
		product.setProductId(CreateUniqId.getUniqId());
		if (!Validate.isSpecification(product))
			return 0;
		return productService.insertProduct(product);
	}

	@Override
	public Pager selectProduct(Product product, boolean isContorller) {
		Pager pager = productService.selectProduct(product, isContorller);
		String strApplicationJson;
		try {
			/**
			 * 把查询条件进行序列化成为可对接的字符串
			 */
			strApplicationJson = MyJsonView.serializableObject(ProductSelectCondition.class, product);
			setPagerSelectCondition(pager, strApplicationJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pager;
	}

	@Override
	public Product selectByIdProduct(String productId, boolean isContorller) {
		return productService.selectByIdProduct(productId, isContorller);
	}

	@Override
	public int selectCountProduct(Product product, boolean isContorller) {
		return productService.selectCountProduct(product, isContorller);
	}

}