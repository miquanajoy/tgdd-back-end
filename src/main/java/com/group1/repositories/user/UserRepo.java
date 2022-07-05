package com.group1.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group1.entities.user.User;

public interface UserRepo extends JpaRepository<User, String>{

}
