package com.group1.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.group1.entities.user.User;


public interface UserRepo extends JpaRepository<User, Integer> {
	
	@Query("SELECT u FROM User u WHERE u.userName =?1")
	public User findByUsername(String username);
	public static User findByUserNameAndPassWord(String userName,String passWord) {
		// TODO Auto-generated method stub
		return null;
	}
}