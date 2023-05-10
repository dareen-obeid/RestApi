package com.dareen.Project.controller;

import org.springframework.web.bind.annotation.RestController;

import com.dareen.Project.repository.PaymentRepository;
import com.dareen.Project.Exception.PaymentNotFoundException;
import com.dareen.Project.model.Ck_Paymentid;
import com.dareen.Project.model.Payments;


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



@RestController
public class PaymentController {

	private final PaymentRepository repository;
	private final PaymentModelAssemble assembler;

	PaymentController(PaymentRepository repository, PaymentModelAssemble assembler) {
		this.repository = repository;
		this.assembler = assembler;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/payments")
	CollectionModel<EntityModel<Payments>> all() {

		List<EntityModel<Payments>> payments = repository.findAll().stream().map(assembler::toModel)
				.collect(Collectors.toList());
		return CollectionModel.of(payments, linkTo(methodOn(PaymentController.class).all()).withSelfRel());
	}
	// end::get-aggregate-root[]

	@PostMapping("/payments")
	Payments newPayments(@RequestBody Payments newPayment) {
		return repository.save(newPayment);
	}

	// Single item

	@GetMapping("/payments/{id}")
	Payments one(@PathVariable Ck_Paymentid id) {

		return repository.findById(id).orElseThrow(() -> new PaymentNotFoundException(id));
	}

	@PutMapping("/customerNumber/{id}/checkNumber")
	Payments replacePayment(@RequestBody Payments newPayment, @PathVariable Ck_Paymentid id) {

		return repository.findById(id).map(Payment -> {
			Payment.setAmount(newPayment.getAmount());
			Payment.setPaymentDate(newPayment.getPaymentDate());
			Payment.setPaymentID(newPayment.getPaymentID());

			return repository.save(Payment);
		}).orElseGet(() -> {
			newPayment.setPaymentID(id);
			return repository.save(newPayment);
		});
	}

	@DeleteMapping("/payments/{id}")
	void deletePatient(@PathVariable Ck_Paymentid id) {
		repository.deleteById(id);
	}

}