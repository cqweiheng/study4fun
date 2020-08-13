package com.study07Collection;

import java.util.HashMap;
import java.util.Set;

public class Test03Map {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();
		map.put("word", 2);
		map.putIfAbsent("word", 0);
		map.put("word2", 3);
		System.out.println(map);

		map.replaceAll((k,v) -> {
			return v+1;
		});
		System.out.println(map);

		System.out.println("===========");
		Set<String> keySet = map.keySet();
		keySet.remove("word2");
		keySet.add("word333");
		System.out.println(map);
	}
}
