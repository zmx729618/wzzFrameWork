package org.wzz.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangzz.core.orm.IBaseDao;
import org.wangzz.core.service.BaseService;
import org.wzz.test.dao.SchoolDao;
import org.wzz.test.domain.School;

@Service
public class SchoolService extends BaseService<School, String> {

	@Autowired SchoolDao schoolDao;

	@Override
	protected IBaseDao<School, String> getEntityDao() {
		return schoolDao;
	}
	
}
