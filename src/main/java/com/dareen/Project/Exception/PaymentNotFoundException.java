package com.dareen.Project.Exception;

import com.dareen.Project.model.Ck_Paymentid;

public class PaymentNotFoundException extends RuntimeException {

   public PaymentNotFoundException(Ck_Paymentid id) {
    super("Could not find Payment " + id);
  }
}