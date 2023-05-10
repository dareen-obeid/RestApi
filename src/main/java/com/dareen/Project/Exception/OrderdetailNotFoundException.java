package com.dareen.Project.Exception;

import com.dareen.Project.model.Ck_Orderdetails;

public class OrderdetailNotFoundException extends RuntimeException {
	
   public OrderdetailNotFoundException(Ck_Orderdetails id) {
    super("Could not find orderdetails " + id);
  }
}