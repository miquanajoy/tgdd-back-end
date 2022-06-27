package com.group1.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group1.Entities.productEntities.Category;
import com.group1.repositories.CategoryRepo;

@Service
public class CategoryService {

	@Resource
	CategoryRepo CategoryRepo;
	
	public List<Category> getAllCategorys()
	{
		List<Category> categoryList =CategoryRepo.findAll();
		for(Category item: categoryList) 
		{
			System.out.println(item.toString());
		}
		return categoryList;
	}
	
	public Category getSpecificCategory(Integer CategoryID)
	{
		Category categoryItem =CategoryRepo.findByCategoryID(CategoryID);
			System.out.println(categoryItem.toString());
		return categoryItem;
	}

}
