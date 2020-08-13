package com.example.mybatis02.mybatis.pojo;

import com.example.mybatis02.mybatis.pojo.base.BaseEntity;
import org.apache.ibatis.type.Alias;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.core.GrantedAuthority;

@Alias(value = "role")
public class Role extends BaseEntity /*implements GrantedAuthority, ConfigAttribute*/ {

	private String roleId;

	private String userId;

	private String roleName;

	private String note;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	/*@Override
	public String getAttribute() {
		return roleName;
	}

	@Override
	public String getAuthority() {
		return roleName;
	}*/
}
