package com.example.HospitalManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.HospitalManagementSystem.entity.Bill;
import com.example.HospitalManagementSystem.service.BillService;
import com.example.HospitalManagementSystem.util.AuthorizationUtil;

@RestController
@RequestMapping("/api/bills")
@CrossOrigin(origins = "*")
public class BillController {

    @Autowired
    private BillService billService;

    // Generate bill for appointment
    @PostMapping("/appointment/{appointmentId}")
    public Bill generateBill(@RequestHeader("role") String role,
    		                 @PathVariable Long appointmentId,
                             @RequestBody Bill bill) {
    	AuthorizationUtil.checkRole(role, "RECEPTIONIST", "ADMIN");
    	return billService.generateBill(appointmentId, bill);
    }

    // Get bill by ID
    @GetMapping("/{billId}")
    public Bill getBill(@RequestHeader("role") String role,
    		            @PathVariable Long billId) {
        AuthorizationUtil.checkRole(role, "PATIENT", "ADMIN");

    	return billService.getBillById(billId);
    }
}
