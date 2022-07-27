package com.group1.service.shopping;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group1.entities.shopping.PromoteCode;
import com.group1.repositories.shopping.PromoteCodeRepo;

@Service
public class PromoteCodeService {
	
	@Resource
	private PromoteCodeRepo promoteReposit;

	public List<PromoteCode> getAllPromotes()
	{
		List<PromoteCode> promList = promoteReposit.getAllPromotions();
		//System.out.println(prom.toString());
		return promList;
	}
	
	public void savePromote(PromoteCode promote) 
	{
		
		promoteReposit.save(promote);
	}
	
	public PromoteCode getPromoteByName(String promoteName) 
	{
		PromoteCode prom = new PromoteCode();
		prom = promoteReposit.getPromotionByName(promoteName);
		//System.out.println("Promotion details when found:"+prom.toString());
		if(prom != null) System.out.println("Promotion found:");
		else System.out.println("Promotion not found:");
		return prom;
	}
}