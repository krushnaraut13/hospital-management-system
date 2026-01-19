package com.example.HospitalManagementSystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HospitalManagementSystem.entity.MedicalHistory;
import com.example.HospitalManagementSystem.service.MedicalHistoryService;
import com.example.HospitalManagementSystem.util.AuthorizationUtil;

@RestController
@RequestMapping("/api/medical-history")
@CrossOrigin("*")
public class MedicalHistoryController {

    private final MedicalHistoryService historyService;

    public MedicalHistoryController(MedicalHistoryService historyService) {
        this.historyService = historyService;
    }

    // Add medical history
    @PostMapping("/patient/{patientId}")
    public MedicalHistory addHistory(
            @RequestHeader("role") String role,
            @PathVariable Long patientId,
            @RequestBody MedicalHistory history) {

        AuthorizationUtil.checkRole(role, "DOCTOR");
        return historyService.addMedicalHistory(patientId, history);
    }

    // Get history by patient
    @GetMapping("/patient/{patientId}")
    public List<MedicalHistory> getHistory(@PathVariable Long patientId) {
        return historyService.getHistoryByPatient(patientId);
    }
}
