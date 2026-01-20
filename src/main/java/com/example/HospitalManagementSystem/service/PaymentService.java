package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.entity.Payment;

public interface PaymentService {

    Payment makePayment(Long billId, Payment payment);

    Payment getPaymentById(Long paymentId);
}
