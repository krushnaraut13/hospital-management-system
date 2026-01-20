package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.entity.LabTest;
import java.util.List;

public interface LabTestService {

    LabTest addLabTest(Long patientId, Long appointmentId, LabTest labTest);

    List<LabTest> getLabTestsByPatient(Long patientId);
}
