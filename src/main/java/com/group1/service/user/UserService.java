package com.group1.service.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group1.repositories.user.UserRepo;

@Service
public class UserService {

	@Resource
	UserRepo userRepo;

}
