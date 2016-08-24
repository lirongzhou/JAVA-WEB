package com.mantoto.product.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mantoto.page.Pager;
import com.mantoto.service.base.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import com.mantoto.product.dao.IProductTypeDao;
import com.mantoto.product.model.ProductType;
import com.mantoto.product.service.IProductTypeService;
import com.mantoto.product.cache.IProductTypeCache;

@Service
public class ProductTypeServiceImpl extends ServiceBase implements IProductTypeService {

	@Autowired
	private IProductTypeDao productTypeDao;

	@Autowired
	private IProductTypeCache productTypeCache;

	@Autowired
	private Pager pager;

	@Override
	public boolean deleteProductType(String productTypeId) {
		if (productTypeDao.deleteProductType(productTypeId) >= 1) {
			if (super.isCacheCanUse()) {
				productTypeCache.removeProductType(productTypeId);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean updateProductType(ProductType productType) {
		if (productTypeDao.updateProductType(productType) >= 1) {
			if (super.isCacheCanUse()) {
				productTypeCache.updateCacheByIdProductType(productType.getProductTypeId() + "");
			}
			return true;
		}
		return false;
	}

	@Override
	public long insertProductType(ProductType productType) {
		if (productTypeDao.insertProductType(productType) >= 1) {
			if (super.isCacheCanUse()) {
				productTypeCache.updateCacheByIdProductType(productType.getProductTypeId() + "");
			}
		}
		return 0;
	}

	@Override
	public Pager selectProductType(ProductType productType, boolean isContorller) {
		pager.setPageSize(productType.getPageSize());
		pager.setPageNo(productType.getPageNo());
		if (super.isSelectcacheCanUse() && isContorller) {
			return productTypeCache.selectProductType(productType);
		} else {
			pager.setRowCount(selectCountProductType(productType, isContorller));
			pager.setResultList(productTypeDao.selectProductType(productType));
		}
		return pager;
	}

	@Override
	public int selectCountProductType(ProductType productType, boolean isContorller) {
		if (super.isSelectcacheCanUse() && isContorller)
			return productTypeCache.selectCountProductType(productType);
		return productTypeDao.selectCountProductType(productType);
	}

	@Override
	public ProductType selectByIdProductType(String productTypeId, boolean isContorller) {
		if (super.isSelectcacheCanUse() && isContorller)
			return productTypeCache.selectByIdProductType(productTypeId);
		return productTypeDao.selectByIdProductType(productTypeId);
	}

}