package com.dareen.Project.controller;




	import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

	import org.springframework.hateoas.EntityModel;
	import org.springframework.hateoas.server.RepresentationModelAssembler;
	import org.springframework.stereotype.Component;

import com.dareen.Project.model.Customers;

	@Component
	public class CustomerModelAssemble implements RepresentationModelAssembler<Customers, EntityModel<Customers>> {

	  @Override
	  public EntityModel<Customers> toModel(Customers customer) {

	    return EntityModel.of(customer, //
	        linkTo(methodOn(CustomerController.class).one(customer.getCustomerNumber())).withSelfRel(),
	        linkTo(methodOn(CustomerController.class).all()).withRel("customers"));
	  }
	}