package com.study13Permission;

import java.io.BufferedWriter;
import java.io.FilePermission;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FilePermissionTest {

	public static void main(String[] args) {

		test();
	}

	public static void test(){

		SecurityManager securityManager = System.getSecurityManager();
		// 如果window或Linux的目录E:/test 下的文件没有read权限，则会抛异常
		FilePermission permission = new FilePermission("E:/test/-", "read");
		if(securityManager != null) {
			securityManager.checkPermission(permission);
		}
		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("E:/test/test.txt"), StandardOpenOption.APPEND)) {
			bufferedWriter.write("1234567890");
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("=================");

	}

}
