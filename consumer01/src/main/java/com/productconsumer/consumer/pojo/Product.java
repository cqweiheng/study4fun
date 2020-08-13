package com.productconsumer.consumer.pojo;


import com.productconsumer.consumer.pojo.base.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product extends BaseEntity implements Serializable {

	private String name;

	private BigDecimal price;

	private String note;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
