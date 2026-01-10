package com.example.HospitalManagementSystem.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HospitalManagementSystem.entity.Patient;
import com.example.HospitalManagementSystem.repository.PatientRepository;


@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        Patient existing = getPatientById(id);

        existing.setName(patient.getName());
        existing.setAge(patient.getAge());
        existing.setGender(patient.getGender());
        existing.setContactNumber(patient.getContactNumber());
        existing.setAddress(patient.getAddress());
        existing.setBloodGroup(patient.getBloodGroup());

        return patientRepository.save(existing);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
