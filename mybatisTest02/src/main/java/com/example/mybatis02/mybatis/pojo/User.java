package com.example.mybatis02.mybatis.pojo;

import com.example.mybatis02.mybatis.enumeration.SexEnum;
import com.example.mybatis02.mybatis.pojo.base.BaseEntity;
import org.apache.ibatis.type.Alias;

@Alias(value = "user")
public class User extends BaseEntity {

	private String userName;
	private String pwd;
	private SexEnum sex;
	private String note;

	public User() {
	}

	public User(String userName, String pwd, SexEnum sex) {
		this.userName = userName;
		this.pwd = pwd;
		this.sex = sex;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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
