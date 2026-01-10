package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.entity.Bill;

public interface BillService {

    Bill generateBill(Long appointmentId, Bill bill);

    Bill getBillById(Long billId);
}
