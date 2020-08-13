package com.study03ClassLoader.bean;

import com.study01.Child;

public class Person {

	private com.study01.Person child = new Child("1", "aaa");

	private int age = 5;
	private String name = "小二";

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person{" +
			"child=" + child +
			", age=" + age +
			", name='" + name + '\'' +
			'}';
	}
}
