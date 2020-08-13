package com.study03ClassLoader;

import java.util.ServiceLoader;

public class TestServiceLoader {

	public static void main(String[] args) {
		ServiceLoader<LogService> load = ServiceLoader.load(LogService.class);
		for (LogService logService : load) {
			logService.log("你们好");
			System.out.println(logService.getClass());
		}
	}
}
