package com.spirit;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 2024274728213444381L;

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public Person setName(String name) {
		this.name = name;
		return this;
	}

	public int getAge() {
		return age;
	}

	public Person setAge(int age) {
		this.age = age;
		return this;
	}

	@Override
	public String toString() {
		return "Person{" +
			"name='" + name + '\'' +
			", age=" + age +
			'}';
	}
}
