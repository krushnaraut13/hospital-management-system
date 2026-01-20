package com.example.HospitalManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.HospitalManagementSystem.entity.LabTest;
import java.util.List;

public interface LabTestRepository extends JpaRepository<LabTest, Long> {

    List<LabTest> findByPatientPatientId(Long patientId);
}
