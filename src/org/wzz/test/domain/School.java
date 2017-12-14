package org.wzz.test.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.wangzz.core.orm.BaseUidEntity;

import com.google.common.collect.Lists;

@Entity
public class School extends BaseUidEntity {

	private static final long serialVersionUID = 8460134961084739247L;

	private String name;

	private String description;

	private String tel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Group group;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
	private List<Student> students = Lists.newArrayList();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	

}
