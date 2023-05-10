package com.dareen.Project.controller;


import java.util.List;
import java.util.stream.Collectors;

import com.dareen.Project.Exception.OrderdetailNotFoundException;
import com.dareen.Project.model.Ck_Orderdetails;
import com.dareen.Project.model.Orderdetails;
import com.dareen.Project.repository.OrderDetailRepository;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class OrderdetailController {

	private final OrderDetailRepository repository;
	private final OrderDetailModelAssemble assembler;

	OrderdetailController(OrderDetailRepository repository, OrderDetailModelAssemble assembler) {
		this.repository = repository;
		this.assembler = assembler;
	}

	// Aggregate root
	// tag::get-aggregate-root[]

	@GetMapping("/orderdetails")
	CollectionModel<EntityModel<Orderdetails>> all() {

		List<EntityModel<Orderdetails>> orderdetails = repository.findAll().stream().map(assembler::toModel)
				.collect(Collectors.toList());
		return CollectionModel.of(orderdetails, linkTo(methodOn(OrderdetailController.class).all()).withSelfRel());

	}

	@PostMapping("/orderdetails")
	Orderdetails neworderdetails(@RequestBody Orderdetails neworderdetails) {
		return repository.save(neworderdetails);
	}

	// Single item

	@GetMapping("/orderdetails/{id}")
	Orderdetails one(@PathVariable Ck_Orderdetails id) {

		return repository.findById(id).orElseThrow(() -> new OrderdetailNotFoundException(id));
	}

	@PutMapping("/orderNumber/{id}/productCode")
	Orderdetails replaceorderdetails(@RequestBody Orderdetails neworderdetails, @PathVariable Ck_Orderdetails id) {

		return repository.findById(id).map(orderdetails -> {
			orderdetails.setOrderLineNumber(neworderdetails.getOrderLineNumber());
			orderdetails.setQuantityOrdered(neworderdetails.getQuantityOrdered());
			orderdetails.setPriceEach(neworderdetails.getPriceEach());
			orderdetails.setOrderdetailsID(neworderdetails.getOrderdetailsID());

			return repository.save(orderdetails);
		}).orElseGet(() -> {
			neworderdetails.setOrderdetailsID(id);
			return repository.save(neworderdetails);
		});
	}

	@DeleteMapping("/orderdetails/{id}")
	void deleteorderdetails(@PathVariable Ck_Orderdetails id) {
		repository.deleteById(id);
	}

}