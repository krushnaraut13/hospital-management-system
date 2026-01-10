package com.example.HospitalManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.HospitalManagementSystem.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
