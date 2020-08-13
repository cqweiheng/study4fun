package com.example.mybatis02.mybatis.enumeration;

public enum AvailableEnum {

	USEABLE(1,"可用"),

	UNUSEABLE(0,"不可用");

	private int id;
	private String name;

	AvailableEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public static AvailableEnum getEnumById(int id){
		for(AvailableEnum flag : AvailableEnum.values()){
			if(flag.getId() == id){
				return flag;
			}
		}
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
