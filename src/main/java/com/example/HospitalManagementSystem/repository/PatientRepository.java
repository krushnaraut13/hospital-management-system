package com.example.HospitalManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HospitalManagementSystem.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
