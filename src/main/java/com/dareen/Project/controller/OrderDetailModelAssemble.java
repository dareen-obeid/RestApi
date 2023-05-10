package com.dareen.Project.controller;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.dareen.Project.model.Orderdetails;



@Component
public class OrderDetailModelAssemble implements RepresentationModelAssembler<Orderdetails, EntityModel<Orderdetails>> {

  @Override
  public EntityModel<Orderdetails> toModel(Orderdetails orderdetails) {

    return EntityModel.of(orderdetails, //
        linkTo(methodOn(OrderdetailController.class).one(orderdetails.getOrderdetailsID())).withSelfRel(),
        linkTo(methodOn(OrderdetailController.class).all()).withRel("orderdetails"));
  }
}