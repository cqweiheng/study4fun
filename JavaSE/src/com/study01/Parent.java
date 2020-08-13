package com.study01;

import java.util.Optional;

public class Parent extends Person {

	static {
		System.out.println("Parent static");
	}

	public Parent() {
		System.out.println("Parent constructor");
	}

	public Parent(String name, int age) {
		super(name,age);
	}
	{
		System.out.println("Parent");
	}

	public Optional<Person> getChild(){
		return Optional.of(new Person("阿大", 36));
	}
}
