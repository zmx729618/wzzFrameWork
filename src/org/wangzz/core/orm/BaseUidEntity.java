package org.wangzz.core.orm;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;


/**
 * 主键id为uuid的entity基类.
 * 
 * @author wangzz
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class BaseUidEntity implements Serializable {

	@Id
	@GenericGenerator(name="uu_id", strategy="uuid")
	@GeneratedValue(generator="uu_id")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
		
	
} 
