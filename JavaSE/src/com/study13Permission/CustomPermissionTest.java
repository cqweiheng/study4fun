package com.study13Permission;

public class CustomPermissionTest {

	public static void main(String[] args) {

		SecurityManager securityManager = System.getSecurityManager();
		WordCheckPermission wordCheckPermission = new WordCheckPermission("");
		securityManager.checkPermission(wordCheckPermission);

	}

}
