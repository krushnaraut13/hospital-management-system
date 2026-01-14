package com.example.HospitalManagementSystem.controller;

import org.springframework.web.bind.annotation.*;
import com.example.HospitalManagementSystem.entity.Prescription;
import com.example.HospitalManagementSystem.service.PrescriptionService;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    // Add prescription for appointment
    @PostMapping("/appointment/{appointmentId}")
    public Prescription addPrescription(@PathVariable Long appointmentId,
                                        @RequestBody Prescription prescription) {
        return prescriptionService.addPrescription(appointmentId, prescription);
    }

    // Get prescription by ID
    @GetMapping("/{id}")
    public Prescription getPrescription(@PathVariable Long id) {
        return prescriptionService.getPrescriptionById(id);
    }
}
