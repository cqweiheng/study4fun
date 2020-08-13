package com.study01;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream002 {

	public static void main(String[] args) {
		Optional<Person> optionalPerson = Optional.of(new Child("你好", 11));
		Optional<Person> c = optionalPerson.flatMap(Child::getChild);
		System.out.println(c.get().getName());

		Set set = new HashSet();
		set.add(null);

		Stream.empty().collect(Collectors.toList());

		Object[] objects = {"a","b","c","d"};
		String[] strings = Stream.of(objects).toArray(String[]::new);
		System.out.println("===============");
		System.out.println(strings);
		for (String string : strings) {
			System.out.println(string);
		}


	}

}
