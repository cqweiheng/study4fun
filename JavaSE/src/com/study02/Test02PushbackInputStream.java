package com.study02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.nio.charset.StandardCharsets;

public class Test02PushbackInputStream {

	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Thinkpad\\Desktop\\test.txt");
		PushbackInputStream pushbackInputStream
			= new PushbackInputStream(fileInputStream, 2000);
		int available = pushbackInputStream.available();
		byte[] bytes = new byte[available];
		pushbackInputStream.mark(0);
		int read = pushbackInputStream.read(bytes, 0, available);
		System.out.println("=============read:" + read);
		if(read != -1){
			System.out.println(new String(bytes, StandardCharsets.UTF_8));

			pushbackInputStream.unread(bytes);
		}
		byte[] bytes2 = new byte[available];
		read = fileInputStream.read(bytes2, 0, available);
		System.out.println("=============read:" + read);
		System.out.println(new String(bytes2, StandardCharsets.UTF_8));

	}
}
