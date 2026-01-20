package com.example.HospitalManagementSystem.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.HospitalManagementSystem.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByBill_BillId(Long billId);
}
