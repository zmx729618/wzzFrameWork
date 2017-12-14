package org.wzz.test.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;

import org.wangzz.core.orm.BaseIncEntity;

@Entity
public class Product extends BaseIncEntity {
	
	private static final long serialVersionUID = 1L;

	private String name;

	private String description;
	
	private BigDecimal price = new BigDecimal(0.00);

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
