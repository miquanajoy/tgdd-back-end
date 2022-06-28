package com.group1.dto;

public enum PromotionCodeType {
	
	PERCENT("Percent")
	, AMOUNT("Amount");
	
	private final String displayvalue;
	
	PromotionCodeType(String displayvalue) {
		this.displayvalue = displayvalue;
		// TODO Auto-generated constructor stub
	}

	public String getDisplayvalue() {
		return displayvalue;
	}	
	
	
}
