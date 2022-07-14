package com.group1.entities.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//mqfixed
@Entity
@Table(name = "user")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserID")
	private String userId;
	
	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name = "UserName")
	private String userName;
	
	@Column(name = "PassWord")
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "RoleID",referencedColumnName = "RoleID", insertable = false, updatable = false)
	private Role roleIdentity;
	
	@Column(name = "RoleID")
	private String roleId;
	
	@Column(name = "Enabled")
	private Boolean enabled;
	
	@Column(name = "Status")
	private Boolean status;

	public User() {
	}

	public User(String userId, String firstName, String lastName, String userName, String password, Role roleIdentity,
			String roleId, Boolean enabled, Boolean status) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.roleIdentity = roleIdentity;
		this.roleId = roleId;
		this.enabled = enabled;
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRoleIdentity() {
		return roleIdentity;
	}

	public void setRoleIdentity(Role roleIdentity) {
		this.roleIdentity = roleIdentity;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "userId=" + userId + "\n       firstName=" + firstName + "\n       lastName=" + lastName
				+ "\n       userName=" + userName + "\n       password=" + password + "\n       roleIdentity="
				+ roleIdentity + "\n       roleId=" + roleId + "\n       enabled=" + enabled + "\n       status="
				+ status;
	}

}
