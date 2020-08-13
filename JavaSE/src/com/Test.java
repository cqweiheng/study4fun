package com;

import com.study01.Person;

import javax.xml.bind.SchemaOutputResolver;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

public class Test {

	public void test(){

//		System.out.println(0.30 - 0.10);
	}

	public static void main(String[] args) throws InterruptedException {

		new Test().test();

		/*int[] ints = {1, 2, 3, 4, 5, 6};
//		Arrays.parallelSetAll(ints, i -> ++ints[i]);
//		System.out.println("==========");
//		for (int anInt : ints) {
//			System.out.println(anInt);
//		}
		Arrays.parallelPrefix(ints, (x,y) -> x+y);
		for (int anInt : ints) {
			System.out.println(anInt);
		}*/

//		Map<String,Long> map = new HashMap(){{put("a", 1L);}};
//		map.compute("a", (k,v) -> {
//			System.out.println(k);
//			System.out.println(v);
//			return 11L;
//		});
//
//		System.out.println(map);
//		Long res = map.merge("a", 2L, Long::sum);
//		System.out.println(map);
//
//		ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
//		concurrentHashMap.search(Long.MAX_VALUE, (k,v) -> {return v;});


//		ReentrantLock lock = new ReentrantLock();
//		Condition condition = lock.newCondition();
//		condition.await();

//		System.out.println(new ArrayList<String>(){{
//			add("1");
//			add("2");
//		}});
	}
}
