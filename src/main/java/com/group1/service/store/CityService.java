package com.group1.service.store;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group1.repositories.store.CityRepo;

@Service
public class CityService {

	@Resource
	CityRepo cityRepo;

}
