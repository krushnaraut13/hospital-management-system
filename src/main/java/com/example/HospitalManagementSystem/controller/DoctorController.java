package com.example.HospitalManagementSystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.HospitalManagementSystem.entity.Doctor;
import com.example.HospitalManagementSystem.service.DoctorService;
import com.example.HospitalManagementSystem.util.AuthorizationUtil;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // Add Doctor
    @PostMapping
    public Doctor addDoctor(@RequestHeader("role") String role,
                            @RequestBody Doctor doctor) {
        
        AuthorizationUtil.checkRole(role, "ADMIN");
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
    
    @GetMapping("/search/name")
    public List<Doctor> searchDoctors(@RequestParam String name) {
        return doctorService.searchDoctorsByName(name);
    }

 // 🔍 Search doctors by specialization
    @GetMapping("/search/specialization")
    public List<Doctor> searchDoctorsBySpecialization(
            @RequestParam String specialization) {
        return doctorService.searchBySpecialization(specialization);
    }
    
    // 🔍 Search by department
    @GetMapping("/search/department")
    public List<Doctor> searchByDepartment(
            @RequestParam String department) {
        return doctorService.searchByDepartment(department);
    }

    // 🔍 Search by availability
    @GetMapping("/search/availability")
    public List<Doctor> searchByAvailability(
            @RequestParam boolean available) {
        return doctorService.searchByAvailability(available);
    }
    
    // Combined filter API
    //Combined filters reduce multiple API calls, improve performance, and provide accurate results in a single request.
    //“Show me all available doctors from the Cardiology[Specific] department.”
    @GetMapping("/filter")
    public List<Doctor> filterDoctors(
            @RequestParam String department,
            @RequestParam boolean available) {
        return doctorService.searchByDepartmentAndAvailability(department, available);
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
