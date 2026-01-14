package com.example.HospitalManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.HospitalManagementSystem.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
