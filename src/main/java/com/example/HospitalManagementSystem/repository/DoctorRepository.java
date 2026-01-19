package com.example.HospitalManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.HospitalManagementSystem.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByNameContainingIgnoreCase(String name);

    List<Doctor> findBySpecializationContainingIgnoreCase(String specialization);

    List<Doctor> findByDepartmentContainingIgnoreCase(String department);

    List<Doctor> findByAvailable(boolean available);

    List<Doctor> findByDepartmentIgnoreCaseAndAvailable(String department,boolean available);

	Object countByAvailable(boolean b);
}
