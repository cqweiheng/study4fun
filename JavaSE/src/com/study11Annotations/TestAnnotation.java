package com.study11Annotations;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.developer.Serialization;
import jdk.nashorn.internal.ir.annotations.Reference;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestAnnotation {

	private String a;

	@ActionListenerFor(source = "main111")
	public static void main(String args[]) throws Exception {
//		new ButtonFrame();
//		test3(null);
		new TestAnnotation().test2("你好");


//		TestAnnotation t = new TestAnnotation();
//		Field f = t.getClass().getDeclaredField("a");
//		f.setAccessible(true);
//		f.set(t, "helloword");
//		System.out.println("-----------------------");
//		System.out.println(t.a);
	}

	@ActionListenerFor(source = "test111", ref = @Reference)
	public void test(){

	}

	public void test2(TestAnnotation this, String hello){
		assert hello != null : "入参不能为null";
		System.out.println("=======" + hello);
		System.out.println("=======" + this);
	}

	public static void test3(@NonNull String arg) throws NoSuchMethodException {
		Method test3 = TestAnnotation.class.getMethod("test3", String.class);
		Parameter[] parameters = test3.getParameters();
		for (Parameter parameter : parameters) {
			Annotation[] annotations = parameter.getAnnotations();
			for (Annotation annotation : annotations) {
				if(annotation instanceof NonNull){
					System.out.println(true);

				}
			}
		}

	}


}
