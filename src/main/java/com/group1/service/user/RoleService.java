package com.group1.service.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group1.repositories.user.RoleRepo;

@Service
public class RoleService {

	@Resource
	RoleRepo roleReposit;

}
