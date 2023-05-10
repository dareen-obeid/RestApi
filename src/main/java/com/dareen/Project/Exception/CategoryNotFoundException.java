package com.dareen.Project.Exception;

public class CategoryNotFoundException extends RuntimeException {
	
	public CategoryNotFoundException(String id) {
	    super("Could not find Category " + id);
	}

}
