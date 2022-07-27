package com.group1.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group1.entities.product.Category;
import com.group1.repositories.product.CategoryRepo;

@Service
public class CategoryService {

	@Resource
	CategoryRepo CategoryRepo;
	
	public List<Category> getAllCategories()
	{
		List<Category> categoryList = CategoryRepo.getCategories();

		for(Category item: categoryList) 
		{
			System.out.println(item.toString());
		}
		return categoryList;
	}
	
	public Category getSpecificCategory(Integer id)
	{
		//System.out.println("Cate name at service:"+name);
		Category categoryItem =CategoryRepo.getCategoryByID(id);
			System.out.println(categoryItem.toString());
		return categoryItem;
	}

}
