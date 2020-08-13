package com.study02;

import com.study01.Child;

import java.util.function.Predicate;

/**
 * 泛型
 * @date 2020/4/12 14:34
 * @author wei.heng
 */
public class Test05 {

	public static void main(String[] args) {
		childTest(new Child("儿子", 5));
//		test(new Person("人", 24));
		Predicate<Integer> predicate = i -> i > 0;
		Predicate<Integer> predicate2 = i -> i % 2 == 0;
		System.out.println(predicate.test(5));
		System.out.println(predicate.test(-1));
		System.out.println(predicate.and(predicate2).test(5));
		System.out.println(predicate.and(predicate2).test(4));
//		System.out.println(predicate.test(5));
	}

	public static <E extends Throwable> void throwAs(Throwable e) throws E{
		throw (E)e;
	}

	public static <T extends Child> void childTest(T p){
		System.out.println(p);
	}

	public static <T extends Child> void superTest(T p){
		System.out.println(p);
	}

}
