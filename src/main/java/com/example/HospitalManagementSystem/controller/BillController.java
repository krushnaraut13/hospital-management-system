package com.example.HospitalManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.HospitalManagementSystem.entity.Bill;
import com.example.HospitalManagementSystem.service.BillService;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    @Autowired
    private BillService billService;

    // Generate bill for appointment
    @PostMapping("/appointment/{appointmentId}")
    public Bill generateBill(@PathVariable Long appointmentId,
                             @RequestBody Bill bill) {
        return billService.generateBill(appointmentId, bill);
    }

    // Get bill by ID
    @GetMapping("/{billId}")
    public Bill getBill(@PathVariable Long billId) {
        return billService.getBillById(billId);
    }
}
