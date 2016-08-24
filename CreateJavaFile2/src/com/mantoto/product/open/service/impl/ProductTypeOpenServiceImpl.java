package com.mantoto.product.open.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantoto.open.service.base.OpenServiceBase;
import com.mantoto.page.Pager;
import com.mantoto.product.jsonView.ProductSelectCondition;
import com.mantoto.product.model.ProductType;
import com.mantoto.product.open.service.IProductTypeOpenService;
import com.mantoto.product.service.IProductTypeService;
import com.mantoto.util.CreateUniqId;
import com.mantoto.util.MyJsonView;
import com.mantoto.util.Validate;

@Service
public class ProductTypeOpenServiceImpl extends OpenServiceBase implements IProductTypeOpenService {

	@Autowired
	private IProductTypeService productTypeService;

	@Override
	public boolean deleteProductType(String productTypeId) {
		return productTypeService.deleteProductType(productTypeId);
	}

	@Override
	public boolean updateProductType(ProductType productType) {
		if (!Validate.updateSpecificationValidate(productType))
			return false;
		return productTypeService.updateProductType(productType);
	}

	@Override
	public long insertProductType(ProductType productType) {
		productType.setProductTypeId(CreateUniqId.getUniqId());
		if (!Validate.isSpecification(productType))
			return 0;
		return productTypeService.insertProductType(productType);
	}

	@Override
	public Pager selectProductType(ProductType productType, boolean isContorller) {
		Pager pager = productTypeService.selectProductType(productType, isContorller);
		String strApplicationJson;
		try {
			/**
			 * 把查询条件进行序列化成为可对接的字符串
			 */
			strApplicationJson = MyJsonView.serializableObject(ProductSelectCondition.class, productType);
			setPagerSelectCondition(pager, strApplicationJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pager;
	}

	@Override
	public int selectCountProductType(ProductType productType, boolean isContorller) {
		return productTypeService.selectCountProductType(productType, isContorller);
	}

	@Override
	public ProductType selectByIdProductType(String productTypeId, boolean isContorller) {
		return productTypeService.selectByIdProductType(productTypeId, isContorller);
	}

}