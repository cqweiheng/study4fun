package com.study01;

public class Person implements IPersonBean{

	protected String id;

	protected String name;

	protected int age;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {

		if(!(obj instanceof Person)){
			return false;
		}
		Person person = (Person)obj;
		return this.name.equals(person.name) && this.age == person.age;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() + this.age;
	}

	@Override
	public String toString() {
		return "Person{" +
			"id='" + id + '\'' +
			", name='" + name + '\'' +
			", age=" + age +
			'}';
	}
}
