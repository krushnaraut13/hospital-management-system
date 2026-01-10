package com.example.HospitalManagementSystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.HospitalManagementSystem.entity.Doctor;
import com.example.HospitalManagementSystem.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // Add Doctor
    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    // Get All Doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // Get Doctor by ID
    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    // Update Doctor
    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id,
                               @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(id, doctor);
    }

    // Delete Doctor
    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return "Doctor deleted successfully";
    }
}
