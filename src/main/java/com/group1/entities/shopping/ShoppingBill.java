package com.group1.entities.shopping;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//mqfixed
@Entity
@Table(name = "shopping_bill")
public class ShoppingBill implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BillID")
	private Integer billId;
	
	@ManyToOne
	@JoinColumn(name = "CustomerID", referencedColumnName = "ID", insertable = false, updatable = false)
	private Customer customerIdentifier;
	
	@OneToMany(mappedBy = "billIdentifier", cascade = CascadeType.ALL)
	private Set<BillDetail> billItems;
	
	@Column(name = "CustomerID")
	private Integer customerID;
	
	@Column(name = "TimeCreated")
	private LocalDateTime timeCreated;
	
	@Column(name= "PromoteCodeID")
	private Integer promoteCodeID;
	
	@ManyToOne
	@JoinColumn(name = "PromoteCodeID", referencedColumnName = "PromoteCodeID", insertable = false, updatable = false)
	private PromoteCode promoteCodeIdentifier;

	@Column(name = "DeliveryAddress")
	private String deliveryAddress;
	
	@Column(name = "DeliveryType")
	private String deliveryType;
	
	@Column(name = "OtherRequirements")
	private String otherRequirements;
	
	@Column(name = "ReplacingReceiverName")
	private String replacingReceiverName;
	
	@Column(name = "ReplacingReceiverGender")
	private String replacingReceiverGender;
	
	@Column(name = "ReplacingReceiverPhoneNumber")
	private String replacingReceiverPhoneNumber;
	
	public ShoppingBill() {
	}

	public ShoppingBill(Integer billId, Customer customerIdentifier, Set<BillDetail> billItems, Integer customerID,
			LocalDateTime timeCreated, Integer promoteCodeID, PromoteCode promoteCodeIdentifier, String deliveryAddress,
			String deliveryType, String otherRequirements, String replacingReceiverName, String replacingReceiverGender,
			String replacingReceiverPhoneNumber) {
		super();
		this.billId = billId;
		this.customerIdentifier = customerIdentifier;
		this.billItems = billItems;
		this.customerID = customerID;
		this.timeCreated = timeCreated;
		this.promoteCodeID = promoteCodeID;
		this.promoteCodeIdentifier = promoteCodeIdentifier;
		this.deliveryAddress = deliveryAddress;
		this.deliveryType = deliveryType;
		this.otherRequirements = otherRequirements;
		this.replacingReceiverName = replacingReceiverName;
		this.replacingReceiverGender = replacingReceiverGender;
		this.replacingReceiverPhoneNumber = replacingReceiverPhoneNumber;
	}

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public Customer getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(Customer customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	public Set<BillDetail> getBillItems() {
		return billItems;
	}

	public void setBillItems(Set<BillDetail> billItems) {
		this.billItems = billItems;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public LocalDateTime getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(LocalDateTime timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Integer getPromoteCodeID() {
		return promoteCodeID;
	}

	public void setPromoteCodeID(Integer promoteCodeID) {
		this.promoteCodeID = promoteCodeID;
	}

	public PromoteCode getPromoteCodeIdentifier() {
		return promoteCodeIdentifier;
	}

	public void setPromoteCodeIdentifier(PromoteCode promoteCodeIdentifier) {
		this.promoteCodeIdentifier = promoteCodeIdentifier;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getOtherRequirements() {
		return otherRequirements;
	}

	public void setOtherRequirements(String otherRequirements) {
		this.otherRequirements = otherRequirements;
	}

	public String getReplacingReceiverName() {
		return replacingReceiverName;
	}

	public void setReplacingReceiverName(String replacingReceiverName) {
		this.replacingReceiverName = replacingReceiverName;
	}

	public String getReplacingReceiverGender() {
		return replacingReceiverGender;
	}

	public void setReplacingReceiverGender(String replacingReceiverGender) {
		this.replacingReceiverGender = replacingReceiverGender;
	}

	public String getReplacingReceiverPhoneNumber() {
		return replacingReceiverPhoneNumber;
	}

	public void setReplacingReceiverPhoneNumber(String replacingReceiverPhoneNumber) {
		this.replacingReceiverPhoneNumber = replacingReceiverPhoneNumber;
	}

	@Override
	public String toString() {
		return "billId=" + billId + "\n       customerIdentifier=" + customerIdentifier + "\n       billItems="
				+ billItems + "\n       customerID=" + customerID + "\n       timeCreated=" + timeCreated
				+ "\n       promoteCodeID=" + promoteCodeID + "\n       promoteCodeIdentifier=" + promoteCodeIdentifier
				+ "\n       deliveryAddress=" + deliveryAddress + "\n       deliveryType=" + deliveryType
				+ "\n       otherRequirements=" + otherRequirements + "\n       replacingReceiverName="
				+ replacingReceiverName + "\n       replacingReceiverGender=" + replacingReceiverGender
				+ "\n       replacingReceiverPhoneNumber=" + replacingReceiverPhoneNumber;
	}

	

}
