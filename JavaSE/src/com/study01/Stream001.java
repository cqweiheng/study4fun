package com.study01;

import java.util.Optional;
import java.util.stream.Stream;

public class Stream001 {

	public static void main(String[] args) {

//		Stream<Integer> stream = Stream.iterate(1, p -> p + 1).peek(
//			e -> System.out.println("Fetching:" + e)
//		).limit(20);

		Stream<Integer> stream = Stream.iterate(1, p -> p + 1).peek(
			e -> System.out.println("Fetching:" + e)
		).limit(20);

		Optional<Integer> s = stream.max(Integer::compareTo);
		System.out.println(s.get());



	}
}
