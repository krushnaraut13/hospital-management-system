package com.example.HospitalManagementSystem.service;

import java.util.List;

import com.example.HospitalManagementSystem.entity.Patient;

public interface PatientService {

    Patient addPatient(Patient patient);

    List<Patient> getAllPatients();

    Patient getPatientById(Long id);

    Patient updatePatient(Long id, Patient patient);

    void deletePatient(Long id);
}
