package com.group1.DTO;

import java.math.BigDecimal;

public class GeneralProductViewDTO {
	String pName;
	BigDecimal pPrice;
	int pWarranty;
	BigDecimal pInterestRate;
	boolean pExclusive;
	String pAccessories;
	boolean pEnabled;

	public GeneralProductViewDTO() {
		
	}

	public GeneralProductViewDTO(String pName, BigDecimal pPrice, int pWarranty, BigDecimal pInterestRate,
			boolean pExclusive, String pAccessories, boolean pEnabled) {
		super();
		this.pName = pName;
		this.pPrice = pPrice;
		this.pWarranty = pWarranty;
		this.pInterestRate = pInterestRate;
		this.pExclusive = pExclusive;
		this.pAccessories = pAccessories;
		this.pEnabled = pEnabled;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public BigDecimal getpPrice() {
		return pPrice;
	}

	public void setpPrice(BigDecimal pPrice) {
		this.pPrice = pPrice;
	}

	public int getpWarranty() {
		return pWarranty;
	}

	public void setpWarranty(int pWarranty) {
		this.pWarranty = pWarranty;
	}

	public BigDecimal getpInterestRate() {
		return pInterestRate;
	}

	public void setpInterestRate(BigDecimal pInterestRate) {
		this.pInterestRate = pInterestRate;
	}

	public boolean ispExclusive() {
		return pExclusive;
	}

	public void setpExclusive(boolean pExclusive) {
		this.pExclusive = pExclusive;
	}

	public String getpAccessories() {
		return pAccessories;
	}

	public void setpAccessories(String pAccessories) {
		this.pAccessories = pAccessories;
	}

	public boolean ispEnabled() {
		return pEnabled;
	}

	public void setpEnabled(boolean pEnabled) {
		this.pEnabled = pEnabled;
	}
	
	

}
