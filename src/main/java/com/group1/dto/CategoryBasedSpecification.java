package com.group1.dto;

import java.io.Serializable;
import java.util.List;

public class CategoryBasedSpecification implements Serializable{
	
	String category;
	List<SpecSection> section;

	public CategoryBasedSpecification() {
		
	}

	public CategoryBasedSpecification(String category, List<SpecSection> section) {
		super();
		this.category = category;
		this.section = section;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<SpecSection> getSection() {
		return section;
	}

	public void setSection(List<SpecSection> section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return category + "\n    " + section;
	}

	
}
