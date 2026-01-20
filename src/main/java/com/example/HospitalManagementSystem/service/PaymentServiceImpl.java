package com.example.HospitalManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HospitalManagementSystem.entity.Bill;
import com.example.HospitalManagementSystem.entity.Payment;
import com.example.HospitalManagementSystem.repository.BillRepository;
import com.example.HospitalManagementSystem.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BillRepository billRepository;

    @Override
    public Payment makePayment(Long billId, Payment payment) {

        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new RuntimeException("Bill not found"));

        // ❌ Prevent duplicate payment
        paymentRepository.findByBill_BillId(billId)
                .ifPresent(p -> {
                    throw new RuntimeException("Payment already done for this bill");
                });

        payment.setBill(bill);
        payment.setAmount(bill.getTotalAmount());
        payment.setPaymentStatus("SUCCESS");

        // ✅ Mark bill as PAID
        bill.setPaymentStatus("PAID");
        billRepository.save(bill);

        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }
}
