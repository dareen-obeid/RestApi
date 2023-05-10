package com.dareen.Project.Exception;

public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException(Integer id) {
	    super("Could not find Customer " + id);
	}

}
