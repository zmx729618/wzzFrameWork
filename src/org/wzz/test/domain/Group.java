package org.wzz.test.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.wangzz.core.orm.BaseUidEntity;

import com.google.common.collect.Lists;

@Entity
@Table(name="T_Group")
public class Group extends BaseUidEntity {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String gdesc;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
	private List<School> schools = Lists.newArrayList();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGdesc() {
		return gdesc;
	}

	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}

	public List<School> getSchools() {
		return schools;
	}

	public void setSchools(List<School> schools) {
		this.schools = schools;
	}



}
