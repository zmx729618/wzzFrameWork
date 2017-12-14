package org.wzz.test.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String contury;
	
	private String code;
	
	private String description;

	public String getContury() {
		return contury;
	}

	public void setContury(String contury) {
		this.contury = contury;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
