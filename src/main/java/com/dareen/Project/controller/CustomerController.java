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

import com.dareen.Project.Exception.CustomerNotFoundException;
import com.dareen.Project.model.Customers;
import com.dareen.Project.repository.CustomerRepository;


@RestController
class CustomerController {

	  private final CustomerRepository repository;
	  private final CustomerModelAssemble assembler;

  public CustomerController(CustomerRepository repository, CustomerModelAssemble assembler) {
		this.repository = repository;
		this.assembler = assembler;
	}
  
  
// Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/customers")
  CollectionModel<EntityModel<Customers>> all() {

    List<EntityModel<Customers>> customers = repository.findAll().stream() //
        .map(assembler::toModel) //
        .collect(Collectors.toList());
    return CollectionModel.of(customers, linkTo(methodOn(CustomerController.class).all()).withSelfRel());

  }
  // end::get-aggregate-root[]

  @PostMapping("/customers")
  Customers newCustomer(@RequestBody Customers newCustomer) {
    return repository.save(newCustomer);
  }

  // Single item
  
  @GetMapping("/customers/{id}")
  EntityModel<Customers> one(@PathVariable Integer id) {
    
	  Customers customer = repository.findById(id) //
		      .orElseThrow(() -> new CustomerNotFoundException(id));
    return assembler.toModel(customer);
  }

  @PutMapping("/customers/{id}")
  Customers replaceCustomer(@RequestBody Customers newCustomer, @PathVariable Integer id) {
    
    return repository.findById(id)
      .map(customer -> {
    	  customer.setCustomerName(newCustomer.getCustomerName());
    	  customer.setAddressLine1(newCustomer.getAddressLine1());
    	  customer.setAddressLine2(newCustomer.getAddressLine2());
    	  customer.setCity(newCustomer.getCity());
    	  customer.setContactLastName(newCustomer.getContactLastName());
    	  customer.setContactFirstName(newCustomer.getContactFirstName());
    	  customer.setCountry(newCustomer.getCountry());
    	  customer.setCreditLimit(newCustomer.getCreditLimit());
    	  customer.setPhone(newCustomer.getPhone());
    	  customer.setState(newCustomer.getState());
    	  customer.setPostalCode(newCustomer.getPostalCode());    	  
        return repository.save(customer);
      })
      .orElseGet(() -> {
        newCustomer.setCustomerNumber(id);
        return repository.save(newCustomer);
      });
  }

  @DeleteMapping("/customers/{id}")
  void deleteCustomer(@PathVariable Integer id) {
    repository.deleteById(id);
  }
}