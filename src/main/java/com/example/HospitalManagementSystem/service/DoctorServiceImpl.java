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
    public List<Doctor> searchDoctorsByName(String name) {
        return doctorRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Doctor> searchBySpecialization(String specialization) {
        return doctorRepository.findBySpecializationContainingIgnoreCase(specialization);
    }
    @Override
    public List<Doctor> searchByDepartment(String department) {
        return doctorRepository.findByDepartmentContainingIgnoreCase(department);
    }

    @Override
    public List<Doctor> searchByAvailability(boolean available) {
        return doctorRepository.findByAvailable(available);
    }

    @Override
    public List<Doctor> searchByDepartmentAndAvailability(String department,boolean available) {
        return doctorRepository.findByDepartmentIgnoreCaseAndAvailable(department, available);
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
