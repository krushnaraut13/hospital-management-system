package com.example.HospitalManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.HospitalManagementSystem.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
