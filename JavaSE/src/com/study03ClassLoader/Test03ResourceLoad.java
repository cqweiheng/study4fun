package com.study03ClassLoader;

import java.io.IOException;
import java.util.ResourceBundle;

public class Test03ResourceLoad {

	public static void main(String[] args) throws IOException {


		ResourceBundle testResource = ResourceBundle.getBundle("com.study3ClassLoader.TestResource");
		System.out.println(testResource.getString("ch"));
		System.out.println(testResource.getString("en"));

//		Properties properties = System.getProperties();
//		properties.forEach((k,v) -> {
//			System.out.println(k + ":" + v);
//		});

//		Properties p = new Properties();
//		p.setProperty("left", "0");
//		p.setProperty("right", "2");
//		p.store(System.out, "just test");

//		InputStream inputStream = Test03ResourceLoad.class.getResourceAsStream("bean/test.txt");
//		Scanner scanner = new Scanner(inputStream, "UTF-8");
//		while(scanner.hasNextLine()){
//			System.out.println(scanner.nextLine());
//		}
	}
}
