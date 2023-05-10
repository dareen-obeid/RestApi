package com.dareen.Project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Ck_Paymentid implements Serializable {
	@Column(name = "customerNumber")
	private int customerNumber;
	@Column(name = "checkNumber")
	private int checkNumber;


	public Ck_Paymentid(int customerNumber, int checkNumber) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public int getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(int checkNumber) {
		this.checkNumber = checkNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + checkNumber;
		result = prime * result + customerNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ck_Paymentid other = (Ck_Paymentid) obj;
		if (checkNumber != other.checkNumber)
			return false;
		if (customerNumber != other.customerNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ck_Paymentid [customerNumber=" + customerNumber + ", checkNumber=" + checkNumber
				+ ", getCustomerNumber()=" + getCustomerNumber() + ", getCheckNumber()=" + getCheckNumber()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}

}
