package com.dareen.Project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Ck_Orderdetails implements Serializable {
	@Column(name = "orderNumber")
	private int orderNumber;
	@Column(name = "productCode")
	private int productCode;

	public Ck_Orderdetails(int orderNumber, int productCode) {
		super();
		this.orderNumber = orderNumber;
		this.productCode = productCode;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderNumber;
		result = prime * result + productCode;
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
		Ck_Orderdetails other = (Ck_Orderdetails) obj;
		if (orderNumber != other.orderNumber)
			return false;
		if (productCode != other.productCode)
			return false;
		return true;
	}

}
