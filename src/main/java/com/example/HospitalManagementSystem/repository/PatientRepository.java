package com.example.HospitalManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HospitalManagementSystem.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByNameContainingIgnoreCase(String name);
//Search by name is NOT a default CRUD operation.
//There is NO built-in method like:findByName()
//JpaRepository provides only generic CRUD operations. 
//For domain-specific queries like searching patients by name, we define derived query methods in the repository, which Spring Data JPA automatically converts into SQL queries.

    List<Patient> findByNameContainingIgnoreCaseAndGenderIgnoreCaseAndBloodGroupIgnoreCase(
            String name,
            String gender,
            String bloodGroup
    );
    
    List<Patient> findByNameContainingIgnoreCaseAndBloodGroupIgnoreCase(
            String name,
            String bloodGroup
    );
}
