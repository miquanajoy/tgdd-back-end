package com.group1.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role implements Serializable{
	@Id
	private String RoleID;
	private String RoleName;
	
	public Role() {
	}

	public Role(String roleID, String roleName) {
		super();
		RoleID = roleID;
		RoleName = roleName;
	}

	public String getRoleID() {
		return RoleID;
	}

	public void setRoleID(String roleID) {
		RoleID = roleID;
	}

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}
	
	
}