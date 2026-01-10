package com.example.HospitalManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.HospitalManagementSystem.entity.Doctor;
import com.example.HospitalManagementSystem.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctor) {
        Doctor existing = getDoctorById(id);

        existing.setName(doctor.getName());
        existing.setSpecialization(doctor.getSpecialization());
        existing.setExperience(doctor.getExperience());
        existing.setContactNumber(doctor.getContactNumber());
        existing.setEmail(doctor.getEmail());
        existing.setDepartment(doctor.getDepartment());
        existing.setAvailable(doctor.isAvailable());

        return doctorRepository.save(existing);
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
