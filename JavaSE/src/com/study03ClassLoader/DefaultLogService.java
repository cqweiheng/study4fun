package com.study03ClassLoader;

public class DefaultLogService implements LogService {
	@Override
	public void log(String msg) {
		System.out.println("hello:" + msg);
	}
}
