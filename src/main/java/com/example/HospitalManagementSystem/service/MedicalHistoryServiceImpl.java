package com.example.HospitalManagementSystem.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.HospitalManagementSystem.entity.MedicalHistory;
import com.example.HospitalManagementSystem.entity.Patient;
import com.example.HospitalManagementSystem.repository.MedicalHistoryRepository;
import com.example.HospitalManagementSystem.repository.PatientRepository;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {

    private final MedicalHistoryRepository historyRepo;
    private final PatientRepository patientRepo;

    public MedicalHistoryServiceImpl(
            MedicalHistoryRepository historyRepo,
            PatientRepository patientRepo) {
        this.historyRepo = historyRepo;
        this.patientRepo = patientRepo;
    }

    @Override
    public MedicalHistory addMedicalHistory(Long patientId, MedicalHistory history) {

        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        history.setPatient(patient);
        history.setVisitDate(LocalDate.now());

        return historyRepo.save(history);
    }

    @Override
    public List<MedicalHistory> getHistoryByPatient(Long patientId) {
        return historyRepo.findByPatientPatientId(patientId);
    }

	
}
