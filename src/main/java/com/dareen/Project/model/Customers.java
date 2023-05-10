package com.dareen.Project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "customers")
public class Customers {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "customerNumber")
	private Integer customerNumber;
	
	@Column(name = "customerName")	
	private String customerName;
	
	@Column(name = "contactLastName")	
	private String contactLastName;
	
	@Column(name = "contactFirstName")
	private String contactFirstName;
	
	
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private long creditLimit;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="customerNumber")
	private List<Orders> orders;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="customerNumber")
	private List<Payments> payments;

	
	public Customers() {
		super();
		this.orders =new ArrayList<>(); 
		this.payments =new ArrayList<>(); 

	}
	

	public Customers(Integer customerNumber, String customerName, String contactLastName, String contactFirstName,
		String phone, String addressLine1, String addressLine2, String city, String state, String postalCode,
		String country, long creditLimit) {
	super();
	this.customerNumber = customerNumber;
	this.customerName = customerName;
	this.contactLastName = contactLastName;
	this.contactFirstName = contactFirstName;
	this.phone = phone;
	this.addressLine1 = addressLine1;
	this.addressLine2 = addressLine2;
	this.city = city;
	this.state = state;
	this.postalCode = postalCode;
	this.country = country;
	this.creditLimit = creditLimit;
}


	public Integer getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getContactLastName() {
		return contactLastName;
	}


	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}


	public String getContactFirstName() {
		return contactFirstName;
	}


	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddressLine1() {
		return addressLine1;
	}


	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	public String getAddressLine2() {
		return addressLine2;
	}


	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public long getCreditLimit() {
		return creditLimit;
	}


	public void setCreditLimit(long creditLimit) {
		this.creditLimit = creditLimit;
	}


	public List<Orders> getOrders() {
		return orders;
	}


	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}


	public List<Payments> getPayments() {
		return payments;
	}


	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}

	
	}
