package org.wzz.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangzz.core.orm.IBaseDao;
import org.wangzz.core.service.BaseService;
import org.wzz.test.dao.ProductDao;
import org.wzz.test.domain.Product;

@Service
public class ProductService extends BaseService<Product, Long> {
	
	@Autowired ProductDao productDao;

	@Override
	protected IBaseDao<Product, Long> getEntityDao() {
		return productDao;
	}

}
