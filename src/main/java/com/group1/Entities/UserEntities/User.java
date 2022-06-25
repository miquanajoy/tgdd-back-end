package com.group1.Entities.UserEntities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable{
	@Id
	private String UserID;
	private String FirstName;
	private String LastName;
	private String UserName;
	private String Password;
	private Role RoleID;
	private Boolean Enabled;
	private Boolean Status;

	public User() {
	}

	public User(String userID, String firstName, String lastName, String userName, String password, Role roleID,
			Boolean enabled, Boolean status) {
		super();
		UserID = userID;
		FirstName = firstName;
		LastName = lastName;
		UserName = userName;
		Password = password;
		RoleID = roleID;
		Enabled = enabled;
		Status = status;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Role getRoleID() {
		return RoleID;
	}

	public void setRoleID(Role roleID) {
		RoleID = roleID;
	}

	public Boolean getEnabled() {
		return Enabled;
	}

	public void setEnabled(Boolean enabled) {
		Enabled = enabled;
	}

	public Boolean getStatus() {
		return Status;
	}

	public void setStatus(Boolean status) {
		Status = status;
	}

	
}
