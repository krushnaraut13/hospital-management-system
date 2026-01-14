package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.entity.Prescription;

public interface PrescriptionService {

    Prescription addPrescription(Long appointmentId, Prescription prescription);

    Prescription getPrescriptionById(Long id);
}
