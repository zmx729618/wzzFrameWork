package org.wzz.test.string;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wangzz.core.orm.Page;
import org.wangzz.core.test.spring.SpringTransactionalTestCase;
import org.wzz.test.domain.Student;
import org.wzz.test.service.StudentService;

public class TestDao extends SpringTransactionalTestCase {
	
	@Autowired StudentService studentService;
	
	@Test
	public void test1() {
		Page<Student> page = new Page<Student>(10);
		
		page = studentService.findPageByPropertyLike(page, null, null);
		
		System.out.println(page.getTotalCount());
	}
	
}
