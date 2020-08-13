package com.study08TimeAPI;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test01Duration {

	public static void main(String[] args) {
//		runAlgorithm();
		int size = 10;
		List<Integer> list = new Random().ints().map(i -> i % 100).limit(size).boxed().collect(Collectors.toList());
		List<Integer> collect = IntStream.range(1, list.size()).boxed().collect(Collectors.toList());
		System.out.println(collect);
		Collections.shuffle(collect);
		System.out.println(collect);
	}

	public static void runAlgorithm(){
		int size = 10;
		List<Integer> list = new Random().ints().map(i -> i % 100).limit(size).boxed().collect(Collectors.toList());
		Collections.sort(list);
		System.out.println(list);
	}

	public static void runAlgorithm2(){
		int size = 10;
		List<Integer> list = new Random().ints().map(i -> i % 100).limit(size).boxed().collect(Collectors.toList());
		while(!IntStream.range(1, list.size()).allMatch(
			i -> list.get(i - 1).compareTo(list.get(i)) <= 0)){
			Collections.shuffle(list);
		}
		System.out.println(list);
	}
}
