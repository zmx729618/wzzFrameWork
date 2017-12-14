package org.wzz.test.dao;

import org.springframework.stereotype.Repository;
import org.wangzz.core.orm.hibernate.HibernateBaseDao;
import org.wzz.test.domain.Product;

@Repository
public class ProductDao extends HibernateBaseDao<Product, Long> {

}
