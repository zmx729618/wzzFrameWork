package org.wzz.test.dao;

import org.springframework.stereotype.Repository;
import org.wangzz.core.orm.hibernate.HibernateBaseDao;
import org.wzz.test.domain.Student;

@Repository
public class StudentDao extends HibernateBaseDao<Student, String> {

}
