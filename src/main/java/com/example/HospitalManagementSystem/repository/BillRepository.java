package com.example.HospitalManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.HospitalManagementSystem.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
