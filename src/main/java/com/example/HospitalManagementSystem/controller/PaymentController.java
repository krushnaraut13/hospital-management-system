package com.example.HospitalManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.HospitalManagementSystem.entity.Payment;
import com.example.HospitalManagementSystem.service.PaymentService;
import com.example.HospitalManagementSystem.util.AuthorizationUtil;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Make payment
    @PostMapping("/bill/{billId}")
    public Payment makePayment(@RequestHeader("role") String role,
                               @PathVariable Long billId,
                               @RequestBody Payment payment) {

        AuthorizationUtil.checkRole(role, "PATIENT", "RECEPTIONIST");
        return paymentService.makePayment(billId, payment);
    }

    // Get payment by ID
    @GetMapping("/{paymentId}")
    public Payment getPayment(@RequestHeader("role") String role,
                              @PathVariable Long paymentId) {

        AuthorizationUtil.checkRole(role, "ADMIN", "PATIENT");
        return paymentService.getPaymentById(paymentId);
    }
}
