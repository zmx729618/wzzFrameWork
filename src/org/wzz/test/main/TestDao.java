package org.wzz.test.main;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wangzz.core.test.spring.SpringTransactionalTestCase;
import org.wzz.test.dao.StudentDao;
import org.wzz.test.domain.Student;

@SuppressWarnings("unchecked")
public class TestDao extends SpringTransactionalTestCase {

	@Autowired StudentDao studentDao;

	
	
	@Test
	public void test2() {	//school.group.name
		Criteria criteria = studentDao.getSession().createCriteria(Student.class);
		criteria.createAlias("school", "school");
		criteria.createAlias("school.group", "group");   
//		criteria.createAlias("school.group", "group");   
		criteria.add(Restrictions.like("group.name", "aaa", MatchMode.ANYWHERE));
		criteria.add(Restrictions.like("school.name", "bbb", MatchMode.ANYWHERE));
		
//		System.out.println(criteria.getEntityOrClassName());
		
		
//		List list = criteria.list();
//		System.out.println(list.size());
		
	}
	
//	@Test
	public void test3() {
		Map<?, ?> map = studentDao.getSessionFactory().getAllClassMetadata();
		for (Map.Entry<?, ?> entry : map.entrySet()) {
			System.out.println(entry.getKey().getClass());
			System.out.println(entry.getValue().getClass());
			String s1 = entry.getKey().toString();
			String s2 = entry.getValue().toString();
			System.out.println(s1+ " ------- " + s2);
		}
		
	}
	
	
}
