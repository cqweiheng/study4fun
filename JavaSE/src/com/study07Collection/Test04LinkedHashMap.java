package com.study07Collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test04LinkedHashMap {

	// 保留最常访问的5个元素
	public static void main(String[] args) {

		class MyLinkedHashMap<K,V> extends LinkedHashMap {
			@Override
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > 5;
//				return (Integer)eldest.getValue() < 3;
			}
		}

		LinkedHashMap<String, Integer> map = new MyLinkedHashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);
		map.put("e", 5);
		System.out.println(map);
		int a = map.remove("a");
		map.put("a", a);
		System.out.println(map);
		Integer c = map.remove("c");
		map.put("c", c);
		System.out.println(map);
		map.put("f", 6);
		System.out.println(map);
	}
}
