package com.study07Collection;

import java.util.*;

public class Test05Enum {

	public static void main(String[] args) {

//		System.out.println(WeekdayEnum.MONDAY);
//		System.out.println(WeekdayEnum.MONDAY.getName());

//		List<String> strings = Collections.nCopies(2, "a");
//		System.out.println(strings);

		Map<String, String> stringStringMap = Collections.singletonMap("a", "1");
//		stringStringMap.put("b", "2");
		System.out.println(stringStringMap);


		System.out.println(new Integer(55).compareTo(new Integer(22)));
	}

	public <T extends Comparable> T test(T t){

		return t;
	}
}
