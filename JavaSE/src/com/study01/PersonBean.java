package com.study01;

public class PersonBean implements IPersonBean {

	private String name;

	public PersonBean(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}
