package com.study04Socket;

import com.study01.Person;

import java.util.*;
import java.util.function.Predicate;

public class Test03 {
	public static void main(String[] args) {
//		CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
//		new Properties().remove("");

		List<Person> list = new ArrayList<>();
		Arrays.sort(list.toArray(new Person[0]), Comparator.comparing(Person::getName));
		System.out.println(Predicate.isEqual("e").test("e"));

//		Comparator.nullsFirst()

//		Console console = System.console();
//		String s = new String(console.readPassword("Password:"));
//		System.out.println("====password:" + s);

	}
}
