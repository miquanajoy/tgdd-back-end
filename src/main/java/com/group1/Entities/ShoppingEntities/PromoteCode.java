package com.group1.Entities.ShoppingEntities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PromoteCode implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int PromoteCodeID;
	private String PromoteCodeName;
	private String PromoteCodeDescription;
	private Enum PromotionType;
	private int Discount;
	private LocalDateTime StartDate;
	private LocalDateTime EndDate;
	private Boolean Enabled;

	public PromoteCode() {
	}

	public PromoteCode(int promoteCodeID, String promoteCodeName, String promoteCodeDescription, Enum promotionType,
			int discount, LocalDateTime startDate, LocalDateTime endDate, Boolean enabled) {
		super();
		PromoteCodeID = promoteCodeID;
		PromoteCodeName = promoteCodeName;
		PromoteCodeDescription = promoteCodeDescription;
		PromotionType = promotionType;
		Discount = discount;
		StartDate = startDate;
		EndDate = endDate;
		Enabled = enabled;
	}

	public int getPromoteCodeID() {
		return PromoteCodeID;
	}

	public void setPromoteCodeID(int promoteCodeID) {
		PromoteCodeID = promoteCodeID;
	}

	public String getPromoteCodeName() {
		return PromoteCodeName;
	}

	public void setPromoteCodeName(String promoteCodeName) {
		PromoteCodeName = promoteCodeName;
	}

	public String getPromoteCodeDescription() {
		return PromoteCodeDescription;
	}

	public void setPromoteCodeDescription(String promoteCodeDescription) {
		PromoteCodeDescription = promoteCodeDescription;
	}

	public Enum getPromotionType() {
		return PromotionType;
	}

	public void setPromotionType(Enum promotionType) {
		PromotionType = promotionType;
	}

	public int getDiscount() {
		return Discount;
	}

	public void setDiscount(int discount) {
		Discount = discount;
	}

	public LocalDateTime getStartDate() {
		return StartDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		StartDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return EndDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		EndDate = endDate;
	}

	public Boolean getEnabled() {
		return Enabled;
	}

	public void setEnabled(Boolean enabled) {
		Enabled = enabled;
	}

	
}
