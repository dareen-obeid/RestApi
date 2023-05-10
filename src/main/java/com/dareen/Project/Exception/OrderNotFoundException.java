package com.dareen.Project.Exception;

public class OrderNotFoundException extends RuntimeException {
	
	public OrderNotFoundException(Integer id) {
	    super("Could not find Order " + id);
	}

}
