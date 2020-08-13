package com.springcloud.productprovider.pojo;

import com.springcloud.productprovider.pojo.base.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.math.BigDecimal;

@Alias(value = "product")
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
