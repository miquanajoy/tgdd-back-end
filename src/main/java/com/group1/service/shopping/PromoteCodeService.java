package com.group1.service.shopping;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group1.entities.shopping.PromoteCode;
import com.group1.repositories.shopping.PromoteCodeRepo;

@Service
public class PromoteCodeService {
	
	@Resource
	PromoteCodeRepo promoteRepo;
	
	public PromoteCode getPromoteByName(String promoteName) 
	{
		PromoteCode prom = promoteRepo.findByPromoteCodeName(promoteName);
		System.out.println(prom.toString());
		return prom;
	}
	
	public List<PromoteCode> getAllPromotes()
	{
		List<PromoteCode> promList = promoteRepo.findAll();
		//System.out.println(prom.toString());
		return promList;
	}
	
	public void savePromote(PromoteCode promote) 
	{
		
		promoteRepo.save(promote);
	}
}
