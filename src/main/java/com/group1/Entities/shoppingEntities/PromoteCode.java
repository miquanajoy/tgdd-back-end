package com.group1.Entities.shoppingEntities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//mqfixed
@Entity
@Table(name = "promotecode")
public class PromoteCode implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PromoteCodeID")
	private Integer promoteCodeId;
	@Column(name = "PromoteCodeName")
	private String promoteCodeName;
	@Column(name = "PromoteCodeDescription")
	private String promoteCodeDescription;
	@Column(name = "PromotionType")
	private Enum promotionType;
	@Column(name = "Discount")
	private Integer discount;
	@Column(name = "StartDate")
	private LocalDateTime startDate;
	@Column(name = "EndDate")
	private LocalDateTime endDate;
	@Column(name = "Enabled")
	private Boolean enabled;

	public PromoteCode() {
	}

	public PromoteCode(Integer promoteCodeId, String promoteCodeName, String promoteCodeDescription, Enum promotionType,
			Integer discount, LocalDateTime startDate, LocalDateTime endDate, Boolean enabled) {
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

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
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
