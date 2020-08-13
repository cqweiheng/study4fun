package com.study02;

public class Test {


	public static void main(String[] args) {
		// 读取用extends
		Plate<? extends Fruit> p = new Plate<Apple>(new Apple());
//		p.setItem(new Fruit());    //Error
//		p.setItem(new Apple());    //Error
		Fruit newFruit1 = p.getItem();
		Object newFruit2=p.getItem();
//		Apple newFruit3=p.getItem();	//Error

	}

	public static void test(){
		// 插入用 super
		Plate<? super Fruit> p = new Plate<Fruit>(new Fruit());
		p.setItem(new Fruit());
		p.setItem(new Apple());


//		Apple newFruit3=p.getItem();	// Error
//		Fruit newFruit1=p.getItem();	// Error
		Object newFruit2=p.getItem();
	}
}
