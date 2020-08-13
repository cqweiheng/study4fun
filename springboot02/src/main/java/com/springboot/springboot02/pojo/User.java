package com.springboot.springboot02.pojo;


import com.springboot.springboot02.enumeration.SexEnum;
import com.springboot.springboot02.pojo.base.BaseEntity;

public class User extends BaseEntity {

	private String userName;
	private SexEnum sex;
	private String note;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
