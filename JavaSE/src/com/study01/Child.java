package com.study01;

import java.util.Optional;

public class Child extends Person implements IPersonBean{

	{
		System.out.println("Child");
	}

	static {
		System.out.println("Child static");
	}

	public Child() {
	}

	public Child(String id, String name) {
		super(id,name);
	}

	public Child(String name, int age) {
		super(name,age);
	}

	public static Optional<Person> getChild(Person p){
		return Optional.of(new Person("阿二", 24));
	}

	@Override
	public String toString() {
		return "Child{" +
			"id='" + id + '\'' +
			", name='" + name + '\'' +
			", age=" + age +
			'}';
	}
}
