package com.group1.entities.user;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//mqfixed
@Entity
@Table(name = "role")
public class Role implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RoleID")
	private String roleId;
	
	@OneToMany(mappedBy = "roleIdentity", cascade = CascadeType.ALL)
	private Set<User> usersWithRoleID;
	
	@Column(name = "RoleName")
	private String roleName;
	
	public Role() {
	}

	public Role(String roleId, Set<User> usersWithRoleID, String roleName) {
		super();
		this.roleId = roleId;
		this.usersWithRoleID = usersWithRoleID;
		this.roleName = roleName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Set<User> getUsersWithRoleID() {
		return usersWithRoleID;
	}

	public void setUsersWithRoleID(Set<User> usersWithRoleID) {
		this.usersWithRoleID = usersWithRoleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "roleId=" + roleId + "\n       usersWithRoleID=" + usersWithRoleID + "\n       roleName=" + roleName;
	}

	
}