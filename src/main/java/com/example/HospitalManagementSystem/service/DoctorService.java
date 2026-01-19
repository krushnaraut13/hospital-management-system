package com.example.HospitalManagementSystem.service;

import java.util.List;
import com.example.HospitalManagementSystem.entity.Doctor;

public interface DoctorService {

    Doctor addDoctor(Doctor doctor);

    List<Doctor> getAllDoctors();

    Doctor getDoctorById(Long id);

    Doctor updateDoctor(Long id, Doctor doctor);

    void deleteDoctor(Long id);
    
    List<Doctor> searchDoctorsByName(String name);

    List<Doctor> searchBySpecialization(String specialization);

    List<Doctor> searchByDepartment(String department);

    List<Doctor> searchByAvailability(boolean available);

    List<Doctor> searchByDepartmentAndAvailability(String department,boolean available);
}
