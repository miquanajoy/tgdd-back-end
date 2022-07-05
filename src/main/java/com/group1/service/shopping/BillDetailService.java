package com.group1.service.shopping;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group1.repositories.shopping.BillDetailRepo;

@Service
public class BillDetailService {

	@Resource
	BillDetailRepo billDetailRepo;

}
