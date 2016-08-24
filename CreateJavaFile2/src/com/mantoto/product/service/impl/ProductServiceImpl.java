package com.mantoto.product.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mantoto.page.Pager;
import com.mantoto.service.base.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import com.mantoto.product.dao.IProductDao;
import com.mantoto.product.model.Product;
import com.mantoto.product.service.IProductService;
import com.mantoto.product.cache.IProductCache;

@Service
public class ProductServiceImpl extends ServiceBase implements IProductService {

	@Autowired
	private IProductDao productDao;

	@Autowired
	private IProductCache productCache;

	@Autowired
	private Pager pager;

	@Override
	public boolean deleteProduct(String productId) {
		if (productDao.deleteProduct(productId) >= 1) {
			if (super.isCacheCanUse()) {
				productCache.removeProduct(productId);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		if (productDao.updateProduct(product) >= 1) {
			if (super.isCacheCanUse()) {
				productCache.updateCacheByIdProduct(product.getProductId() + "");
			}
			return true;
		}
		return false;
	}

	@Override
	public long insertProduct(Product product) {
		if (productDao.insertProduct(product) >= 1) {
			if (super.isCacheCanUse()) {
				productCache.updateCacheByIdProduct(product.getProductId() + "");
			}
		}
		return 0;
	}

	@Override
	public Pager selectProduct(Product product, boolean isContorller) {
		pager.setPageSize(product.getPageSize());
		pager.setPageNo(product.getPageNo());
		if (super.isSelectcacheCanUse() && isContorller) {
			return productCache.selectProduct(product);
		} else {
			pager.setRowCount(selectCountProduct(product, isContorller));
			pager.setResultList(productDao.selectProduct(product));
		}
		return pager;
	}

	@Override
	public Product selectByIdProduct(String productId, boolean isContorller) {
		if (super.isSelectcacheCanUse() && isContorller)
			return productCache.selectByIdProduct(productId);
		return productDao.selectByIdProduct(productId);
	}

	@Override
	public int selectCountProduct(Product product, boolean isContorller) {
		if (super.isSelectcacheCanUse() && isContorller)
			return productCache.selectCountProduct(product);
		return productDao.selectCountProduct(product);
	}

}