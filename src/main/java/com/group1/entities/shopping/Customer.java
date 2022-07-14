package com.group1.entities.shopping;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@OneToMany(mappedBy = "customerIdentifier", cascade = CascadeType.ALL)
	private Set<CustomerAddresses> customerAddresses;
	
	@OneToMany(mappedBy = "customerIdentifier", cascade = CascadeType.ALL)
	private Set<ShoppingBill> customerBills;
	
	@Column(name = "FullName")
	private String fullName;
	
	@Column(name = "PhoneNumber")
	private String phoneNumber;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "Active")
	private Boolean active;

	public Customer() {

	}

	public Customer(Integer id, Set<CustomerAddresses> customerAddresses, Set<ShoppingBill> customerBills,
			String fullName, String phoneNumber, String gender, Boolean active) {
		super();
		this.id = id;
		this.customerAddresses = customerAddresses;
		this.customerBills = customerBills;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<CustomerAddresses> getCustomerAddresses() {
		return customerAddresses;
	}

	public void setCustomerAddresses(Set<CustomerAddresses> customerAddresses) {
		this.customerAddresses = customerAddresses;
	}

	public Set<ShoppingBill> getCustomerBills() {
		return customerBills;
	}

	public void setCustomerBills(Set<ShoppingBill> customerBills) {
		this.customerBills = customerBills;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "id=" + id + "\n       customerAddresses=" + customerAddresses + "\n       customerBills="
				+ customerBills + "\n       fullName=" + fullName + "\n       phoneNumber=" + phoneNumber
				+ "\n       gender=" + gender + "\n       active=" + active;
	}

}
