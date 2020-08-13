package com.weiheng.orderprovider.pojo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_order")
public class Order {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "name", nullable = true, length = 20)
	private String name;

	@Column(name = "price", nullable = true, precision = 5, scale = 2)
	private BigDecimal price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Order{" +
			"id=" + id +
			", name='" + name + '\'' +
			", price=" + price +
			'}';
	}
}
