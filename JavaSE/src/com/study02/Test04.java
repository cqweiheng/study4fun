package com.study02;

import java.util.ArrayList;

public class Test04 {

	public static void main(String[] args) throws Exception {
//		C:\Users\Thinkpad\Desktop
//		Path path = Paths.get("c:","Users","Thinkpad","Desktop","试验检测依据.txt");
//		Path path = Paths.get("C:\\Users","Thinkpad\\Desktop","\\试验检测依据.txt");
//		List<String> strings = Files.readAllLines(path);
//		System.out.println(strings);
//		Supplier<Test04> supplier = () -> new Test04();
//		Supplier<Test04> supplier2 = Test04::new;
//
//		Path target = Paths.get("D:/");
//		Path source = Paths.get("G:/A/test.txt");
//		Path path1 = Paths.get("G:/Z/test.txt");
//		Path relativize = source.relativize(path1);
//		System.out.println("============");
//		System.out.println(relativize.toString());
//		Path resolve = target.resolve(relativize);
//		System.out.println(resolve.toString());
//		Path normalize = resolve.normalize();
//		System.out.println(normalize);
		ArrayList<Object> array = new ArrayList();
		String[] strings = array.toArray(new String[10]);

		System.out.println(new Test04[10].getClass().getComponentType());
	}

//	public static <T> T get(T t) throws Exception{
//		return t.getClass().newInstance();
//	}
}
