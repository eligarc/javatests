package com.eliogrc.javastests.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
