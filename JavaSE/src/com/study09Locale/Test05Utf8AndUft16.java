package com.study09Locale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test05Utf8AndUft16 {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader =
			Files.newBufferedReader(Paths.get("C:\\Users\\Thinkpad\\Desktop", "任务检测依据2.txt")
				, StandardCharsets.UTF_8);
		String s;
		while((s = bufferedReader.readLine()) != null){
			System.out.println(s);
		}
	}
}
