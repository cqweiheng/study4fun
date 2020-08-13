package com.study13Permission;

import java.security.Permission;

public class WordCheckPermission extends Permission {

	public WordCheckPermission(String name) {
		super(name);
	}

	@Override
	public boolean implies(Permission permission) {
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public String getActions() {
		return null;
	}
}
