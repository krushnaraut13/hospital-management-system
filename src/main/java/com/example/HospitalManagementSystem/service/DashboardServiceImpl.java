package com.example.HospitalManagementSystem.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.HospitalManagementSystem.repository.AppointmentRepository;
import com.example.HospitalManagementSystem.repository.BillRepository;
import com.example.HospitalManagementSystem.repository.DoctorRepository;
import com.example.HospitalManagementSystem.repository.PatientRepository;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
	private final BillRepository billRepository;

    public DashboardServiceImpl(
            PatientRepository patientRepository,
            DoctorRepository doctorRepository,
            AppointmentRepository appointmentRepository,
            BillRepository billRepository )
    {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.billRepository=billRepository;
    }

    @Override
    public Map<String, Object> getSummary() {

        Map<String, Object> dashboard = new HashMap<>();

        dashboard.put("totalPatients", patientRepository.count());
        dashboard.put("totalDoctors", doctorRepository.count());
        dashboard.put("availableDoctors", doctorRepository.countByAvailable(true));
        dashboard.put("todayAppointments",appointmentRepository.count());
        dashboard.put("pendingBills", billRepository.countByPaymentStatus("UNPAID"));
        return dashboard;
    }
}
