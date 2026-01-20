package com.example.HospitalManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.HospitalManagementSystem.entity.LabTest;
import com.example.HospitalManagementSystem.service.LabTestService;
import com.example.HospitalManagementSystem.util.AuthorizationUtil;

import java.util.List;

@RestController
@RequestMapping("/api/labtests")
@CrossOrigin(origins = "*")
public class LabTestController {

    @Autowired
    private LabTestService labTestService;

    // Add lab test (Doctor / Lab Staff)
    @PostMapping("/patient/{patientId}/appointment/{appointmentId}")
    public LabTest addLabTest(@RequestHeader("role") String role,
                              @PathVariable Long patientId,
                              @PathVariable Long appointmentId,
                              @RequestBody LabTest labTest) {

        AuthorizationUtil.checkRole(role, "DOCTOR", "ADMIN");
        return labTestService.addLabTest(patientId, appointmentId, labTest);
    }

    // View patient lab tests
    @GetMapping("/patient/{patientId}")
    public List<LabTest> getLabTests(@RequestHeader("role") String role,
                                     @PathVariable Long patientId) {

        AuthorizationUtil.checkRole(role, "DOCTOR", "PATIENT", "ADMIN");
        return labTestService.getLabTestsByPatient(patientId);
    }
}
