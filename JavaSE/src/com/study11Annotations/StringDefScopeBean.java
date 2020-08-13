package com.study11Annotations;

public class StringDefScopeBean {

	@StringDefScope({"AA","BB"})
	private String a;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
}
