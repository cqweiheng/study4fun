package com.study06Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test01Log {

	public static void main(String[] args) throws IOException {
//		Logger.getGlobal().setLevel(Level.INFO);
//		Logger.getLogger("Test01Log").log(Level.INFO, "测试");
//		Logger.getLogger("Test01Log").entering();
//		Logger.getLogger("Test01Log").exiting();

		// 跟踪流的日志
		Logger.getGlobal().setLevel(Level.FINER);
		Logger logger = Logger.getLogger("Test01Log");

		logger.setLevel(Level.INFO);
		logger.entering("java.io.BufferedReader", "readLine", new Object[]{"任务检测依据.txt"});
		List<String> strings = Files.readAllLines(
			Paths.get("C:\\Users\\Thinkpad\\Desktop\\任务检测依据.txt"), StandardCharsets.UTF_16);
		logger.exiting("java.io.BufferedReader", "readLine", strings);

		System.out.println("===============================");
		for (String string : strings) {
			System.out.println(string);
		}

	}
}
