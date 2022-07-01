package com.group1.dto;

import java.io.Serializable;
import java.util.List;

public class SpecSection implements Serializable{

	String sectionHeader;
	List<Attributes> attributes;
	
	public SpecSection() {
		
	}

	public SpecSection(String sectionHeader, List<Attributes> attributes) {
		super();
		this.sectionHeader = sectionHeader;
		this.attributes = attributes;
	}

	public String getSectionHeader() {
		return sectionHeader;
	}

	public void setSectionHeader(String sectionHeader) {
		this.sectionHeader = sectionHeader;
	}

	public List<Attributes> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attributes> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return sectionHeader + "\n    " + attributes;
	}

	
}
