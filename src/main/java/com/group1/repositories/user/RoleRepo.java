package com.group1.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group1.entities.user.Role;

public interface RoleRepo extends JpaRepository<Role, String>{

}
