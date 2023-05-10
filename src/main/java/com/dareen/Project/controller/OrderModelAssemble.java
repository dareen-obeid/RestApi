package com.dareen.Project.controller;


	import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

	import org.springframework.hateoas.EntityModel;
	import org.springframework.hateoas.server.RepresentationModelAssembler;
	import org.springframework.stereotype.Component;

import com.dareen.Project.model.Customers;
import com.dareen.Project.model.Orders;

	@Component
	public class OrderModelAssemble implements RepresentationModelAssembler<Orders, EntityModel<Orders>> {

	  @Override
	  public EntityModel<Orders> toModel(Orders order) {

	    return EntityModel.of(order, //
	        linkTo(methodOn(OrderController.class).one(order.getOrderNumber())).withSelfRel(),
	        linkTo(methodOn(OrderController.class).all()).withRel("orders"));
	  }
	}