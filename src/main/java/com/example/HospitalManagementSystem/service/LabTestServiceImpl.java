package com.example.HospitalManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HospitalManagementSystem.entity.*;
import com.example.HospitalManagementSystem.repository.*;

import java.util.List;

@Service
public class LabTestServiceImpl implements LabTestService {

    @Autowired
    private LabTestRepository labTestRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public LabTest addLabTest(Long patientId, Long appointmentId, LabTest labTest) {

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        labTest.setPatient(patient);
        labTest.setAppointment(appointment);

        return labTestRepository.save(labTest);
        
    }

    @Override
    public List<LabTest> getLabTestsByPatient(Long patientId) {
        return labTestRepository.findByPatientPatientId(patientId);
    }
}
