package com.dareen.Project.controller;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dareen.Project.Exception.OrderNotFoundException;
import com.dareen.Project.model.Orders;
import com.dareen.Project.repository.OrderRepository;



@RestController
class OrderController {

	  private final OrderRepository repository;
	  private final OrderModelAssemble assembler;


	  OrderController(OrderRepository repository, OrderModelAssemble assembler) {
	    this.repository = repository;
	    this.assembler = assembler;

	  }


  // Aggregate root
  // tag::get-aggregate-root[]
	  @GetMapping("/orders")
	  CollectionModel<EntityModel<Orders>> all() {

	    List<EntityModel<Orders>> orders = repository.findAll().stream() //
	        .map(assembler::toModel) //
	        .collect(Collectors.toList());
	    return CollectionModel.of(orders, linkTo(methodOn(OrderController.class).all()).withSelfRel());

	  }
  // end::get-aggregate-root[]

  @PostMapping("/orders")
  Orders newOrder(@RequestBody Orders newOrder) {
    return repository.save(newOrder);
  }

  // Single item
  
  @GetMapping("/orders/{id}")
  EntityModel<Orders> one(@PathVariable Integer id) {
    
	  Orders Order = repository.findById(id) //
		      .orElseThrow(() -> new OrderNotFoundException(id));
    return assembler.toModel(Order);
  }

  @PutMapping("/orders/{id}")
  Orders replaceOrder(@RequestBody Orders newOrder, @PathVariable Integer id) {
    
    return repository.findById(id)
      .map(order -> {
    	  order.setComments(newOrder.getComments());
    	  order.setStatus(newOrder.getStatus());
    	  order.setOrderDate(newOrder.getOrderDate());
    	  order.setCustomerNumber(newOrder.getCustomerNumber());
    	  order.setRequiredDate(newOrder.getRequiredDate());
    	  order.setShippedDate(newOrder.getShippedDate());
    	  
        return repository.save(order);
      })
      .orElseGet(() -> {
    	  newOrder.setOrderNumber(id);
        return repository.save(newOrder);
      });
  }

  @DeleteMapping("/orders/{id}")
  void deleteOrder(@PathVariable Integer id) {
    repository.deleteById(id);
  }
}