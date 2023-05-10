package com.dareen.Project.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.dareen.Project.model.Payments;




@Component
public class PaymentModelAssemble implements RepresentationModelAssembler<Payments, EntityModel<Payments>> {

  @Override
  public EntityModel<Payments> toModel(Payments Payments) {

    return EntityModel.of(Payments, //
        linkTo(methodOn(PaymentController.class).one(Payments.getPaymentID())).withSelfRel(),
        linkTo(methodOn(PaymentController.class).all()).withRel("Payments"));
  }
}