package com.study01;

import java.util.stream.IntStream;

public class Stream004 {

	public static void main(String[] args) {
//		Random random = new Random();
//		System.out.println(random.nextInt());
//		for (int i = 0; i < 20; i++) {
//			System.out.println(random.nextInt(10));
//		}


//		IntStream.range(5,10).forEach(
//			s -> System.out.println(s)
//		);
		IntStream.rangeClosed(5,10).forEach(System.out::println);
	}
}
