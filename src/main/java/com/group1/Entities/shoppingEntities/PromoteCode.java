package com.group1.Entities.shoppingEntities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "promotecode")
@DynamicInsert
@DynamicUpdate
public class PromoteCode implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PromoteCodeID")
	private Integer promoteCodeID;
	
	@Column(name = "PromoteCodeName")
	private String promoteCodeName;
	
	@Column(name = "PromoteCodeDescription")
	private String promoteCodeDescription;
	
	@Column(name = "DiscountPercent")
	private Integer discountPercent;
	
	@Column(name = "DiscountMaxAmount")
	private Integer discountMaxAmount;
	
	@Column(name = "StartDate")
	private LocalDateTime startDate;
	
	@Column(name = "EndDate")
	private LocalDateTime endDate;
	
	@Transient
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime endDateInput;
	
	@Column(name = "Enabled")
	private Boolean enabled;

	public PromoteCode() {
	}

	public PromoteCode(Integer promoteCodeID, String promoteCodeName, String promoteCodeDescription,
			Integer discountPercent, Integer discountMaxAmount, LocalDateTime startDate, LocalDateTime endDate,
			LocalDateTime endDateInput, Boolean enabled) {
		super();
		this.promoteCodeID = promoteCodeID;
		this.promoteCodeName = promoteCodeName;
		this.promoteCodeDescription = promoteCodeDescription;
		this.discountPercent = discountPercent;
		this.discountMaxAmount = discountMaxAmount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.endDateInput = endDateInput;
		this.enabled = enabled;
	}

	public Integer getPromoteCodeID() {
		return promoteCodeID;
	}

	public void setPromoteCodeID(Integer promoteCodeID) {
		this.promoteCodeID = promoteCodeID;
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

	public Integer getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Integer discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Integer getDiscountMaxAmount() {
		return discountMaxAmount;
	}

	public void setDiscountMaxAmount(Integer discountMaxAmount) {
		this.discountMaxAmount = discountMaxAmount;
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

	public LocalDateTime getEndDateInput() {
		return endDateInput;
	}

	public void setEndDateInput(LocalDateTime endDateInput) {
		this.endDateInput = endDateInput;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "PromoteCode:\n\tpromoteCodeID=" + promoteCodeID + " \n\tpromoteCodeName=" + promoteCodeName
				+ " \n\tpromoteCodeDescription=" + promoteCodeDescription + " \n\tdiscountPercent=" + discountPercent
				+ " \n\tdiscountMaxAmount=" + discountMaxAmount + " \n\tstartDate=" + startDate + " \n\tendDate="
				+ endDate + " \n\tenabled=" + enabled;
	}

	
}
