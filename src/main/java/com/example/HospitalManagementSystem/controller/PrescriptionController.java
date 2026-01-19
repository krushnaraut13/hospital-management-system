package com.example.HospitalManagementSystem.controller;

import org.springframework.web.bind.annotation.*;
import com.example.HospitalManagementSystem.entity.Prescription;
import com.example.HospitalManagementSystem.service.PrescriptionService;
import com.example.HospitalManagementSystem.util.AuthorizationUtil;

@RestController
@RequestMapping("/api/prescriptions")
@CrossOrigin(origins = "*")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    // Add prescription for appointment
    @PostMapping("/appointment/{appointmentId}")
    public Prescription addPrescription(@RequestHeader("role") String role,
    		                            @PathVariable Long appointmentId,
                                        @RequestBody Prescription prescription) {
        AuthorizationUtil.checkRole(role, "DOCTOR");
    	return prescriptionService.addPrescription(appointmentId, prescription);
    }

    // Get prescription by ID
    @GetMapping("/{id}")
    public Prescription getPrescription(@RequestHeader("role") String role,
    		                            @PathVariable Long id) {
    	AuthorizationUtil.checkRole(role, "DOCTOR");
    	return prescriptionService.getPrescriptionById(id);
    }
}
