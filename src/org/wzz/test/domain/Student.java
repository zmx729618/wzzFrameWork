package org.wzz.test.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.wangzz.core.orm.BaseUidEntity;


@Entity
public class Student extends BaseUidEntity {

	private static final long serialVersionUID = 4578543831722270161L;
	
	private String name;
	
	private Integer age;
	
	private Address address;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private School school;
	
	public Student(){}
	
	public Student(String name, Integer age){
		this.name = name;
		this.age = age;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	
	
}
