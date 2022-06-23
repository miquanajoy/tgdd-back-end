package com.group1.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class PromoteCode {
	private Integer promoteCodeId;
	private String promoteCodeName;
	private String promoteCodeDescription;
	private Enum promotionType;
	private Double discount;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Boolean enabled;

	public PromoteCode() {
	}

	public PromoteCode(Integer promoteCodeId, String promoteCodeName, String promoteCodeDescription, Enum promotionType,
			Double discount, LocalDateTime startDate, LocalDateTime endDate, Boolean enabled) {
		this.promoteCodeId = promoteCodeId;
		this.promoteCodeName = promoteCodeName;
		this.promoteCodeDescription = promoteCodeDescription;
		this.promotionType = promotionType;
		this.discount = discount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.enabled = enabled;
	}

	public Integer getPromoteCodeId() {
		return promoteCodeId;
	}

	public void setPromoteCodeId(Integer promoteCodeId) {
		this.promoteCodeId = promoteCodeId;
	}

	public String getPromoteCodeName() {
		return promoteCodeName;
	}

	public void setPromoteCodeName(String promoteCodeName) {
		this.promoteCodeName = promoteCodeName;
	}

	public String getPromoteCodeDescription() {
		return promoteCodeDescription;
	}

	public void setPromoteCodeDescription(String promoteCodeDescription) {
		this.promoteCodeDescription = promoteCodeDescription;
	}

	public Enum getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(Enum promotionType) {
		this.promotionType = promotionType;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
