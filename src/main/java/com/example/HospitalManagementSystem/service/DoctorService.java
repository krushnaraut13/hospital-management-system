package com.example.HospitalManagementSystem.service;

import java.util.List;
import com.example.HospitalManagementSystem.entity.Doctor;

public interface DoctorService {

    Doctor addDoctor(Doctor doctor);

    List<Doctor> getAllDoctors();

    Doctor getDoctorById(Long id);

    Doctor updateDoctor(Long id, Doctor doctor);

    void deleteDoctor(Long id);
}
