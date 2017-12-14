package org.wzz.test.web;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wangzz.core.orm.Page;
import org.wangzz.core.search.Search;
import org.wzz.test.domain.Address;
import org.wzz.test.domain.Product;
import org.wzz.test.domain.School;
import org.wzz.test.domain.Student;
import org.wzz.test.service.ProductService;
import org.wzz.test.service.SchoolService;
import org.wzz.test.service.StudentService;

@Controller
@SuppressWarnings({ "unchecked", "unused" })
public class TestController {

	@Autowired StudentService studentService;
	@Autowired SchoolService schoolService;

	
	@RequestMapping("test/t1")
	public String t1() {
//		School school = new School();
//		school.setDescription("good");school.setName("qinghua");school.setTel("123");
//		schoolService.save(school);
//		
//		Student student1 = new Student("555", 22);
//		Address address = new Address(){{setCode("123");setContury("beijing");}};
//		student1.setAddress(address);
//		student1.setSchool(school);
		
		
//		Student student2 = new Student("666", 25);
//
//		studentService.save(student1);
//		studentService.save(student2);
//		Page<Student> page = new Page<Student>(10);
//		page = studentService.findPage(page);
//		List<Student> list = page.getResult();
//		for (Student s : list) {
//			System.out.println(s.getId() + "-" + s.getName() + "-" + s.getAge());
//		}
		
//		Student student = studentService.findById("4028824628911f240128911ff5950003");
//		System.out.println(student.getName());
		
//		Product product = new Product();
//		product.setDescription("sd");
//		product.setName("htc");
//		product.setPrice(new BigDecimal(150));
//		
//		productService.save(product);
		
//		Product product = productService.findById(1l);
//		System.out.println(product.getName());
		
//		School school = schoolService.findById("4028824628911f240128911f6af90001");
//		System.out.println(school.getName());
		
		
		
		Search search = new Search();
		search.addFilterEqual("school.group.id", "id");
		search.addFilterEqual("school.name", "name");
		List<Student> list = studentService.search(search);
		for (Student s : list) {
			System.out.println(s.getId() + "-" + s.getName() + "-" + s.getAge());
		}
		
		System.out.println("TestController.t1()");

		return "test/t1";
	}

}
