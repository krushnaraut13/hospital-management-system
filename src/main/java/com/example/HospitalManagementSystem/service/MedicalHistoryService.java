package com.example.HospitalManagementSystem.service;

import java.util.List;

import com.example.HospitalManagementSystem.entity.MedicalHistory;

public interface MedicalHistoryService {

    MedicalHistory addMedicalHistory(Long patientId, MedicalHistory history);

    List<MedicalHistory> getHistoryByPatient(Long patientId);
}
