package org.wzz.test.dao;

import org.springframework.stereotype.Repository;
import org.wangzz.core.orm.hibernate.HibernateBaseDao;
import org.wzz.test.domain.School;

@Repository
public class SchoolDao extends HibernateBaseDao<School, String> {

}
