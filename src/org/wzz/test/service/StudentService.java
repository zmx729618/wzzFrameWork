package org.wzz.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangzz.core.orm.IBaseDao;
import org.wangzz.core.service.BaseService;
import org.wzz.test.dao.StudentDao;
import org.wzz.test.domain.Student;

@Service
public class StudentService extends BaseService<Student, String> {
	
	@Autowired
	private StudentDao studentDao;

	@Override
	protected IBaseDao<Student, String> getEntityDao() {
		return studentDao;
	}
	
	

}
