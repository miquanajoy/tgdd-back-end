package com.group1.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class PromoteForm implements Serializable{
	private Integer promoteCodeId;
	
	private String promoteCodeName;
	
	private String promoteCodeDescription;
	
	private PromotionCodeType promotionType;
	
	private Integer discount;
	
	private String startDate;
	
	private String endDate;
	
	private Boolean enabled;

	public PromoteForm() {
	}

	public PromoteForm(Integer promoteCodeId, String promoteCodeName, String promoteCodeDescription, PromotionCodeType promotionType,
			Integer discount, String startDate, String endDate, Boolean enabled) {
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

	public PromotionCodeType getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(PromotionCodeType promotionType) {
		this.promotionType = promotionType;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	
}
