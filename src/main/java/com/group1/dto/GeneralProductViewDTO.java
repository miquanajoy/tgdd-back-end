package com.group1.dto;

public class GeneralProductViewDTO{
	
	String pName;
	int pPrice;
	int pWarranty;
	double pInterestRate;
	boolean pExclusive;
	String pAccessories;
	boolean pEnabled;

	public GeneralProductViewDTO() {
		
	}

	public GeneralProductViewDTO(String pName, int pPrice, int pWarranty, double pInterestRate,
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

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getpWarranty() {
		return pWarranty;
	}

	public void setpWarranty(int pWarranty) {
		this.pWarranty = pWarranty;
	}

	public double getpInterestRate() {
		return pInterestRate;
	}

	public void setpInterestRate(double pInterestRate) {
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
	
	@Override
	public String toString() {
		return "GeneralProductViewDTO:\n\tpName=" + pName + " \n\tpPrice=" + pPrice + " \n\tpWarranty=" + pWarranty
				+ " \n\tpInterestRate=" + pInterestRate + " \n\tpExclusive=" + pExclusive + " \n\tpAccessories="
				+ pAccessories + " \n\tpEnabled=" + pEnabled;
	}

}
