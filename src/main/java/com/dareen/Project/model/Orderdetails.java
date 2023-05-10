package com.dareen.Project.model;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "orderdetails")
public class Orderdetails {
	
	 @EmbeddedId
	private Ck_Orderdetails id;

	private int quantityOrdered;
	private long priceEach;
	private int orderLineNumber;

	public Orderdetails() {
		super();
	}
	
	

	public Orderdetails(int quantityOrdered, long priceEach, int orderLineNumber) {
		super();
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}



	public Ck_Orderdetails getOrderdetailsID() {
		return id;
	}

	public void setOrderdetailsID(Ck_Orderdetails id) {
		this.id = id;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public long getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(long priceEach) {
		this.priceEach = priceEach;
	}

	public int getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}





	
	
}

