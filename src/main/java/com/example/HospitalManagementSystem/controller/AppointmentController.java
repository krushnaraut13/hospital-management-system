package com.example.HospitalManagementSystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.HospitalManagementSystem.entity.Appointment;
import com.example.HospitalManagementSystem.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // Book Appointment
    @PostMapping("/patient/{patientId}/doctor/{doctorId}")
    public Appointment bookAppointment(@PathVariable Long patientId,
                                       @PathVariable Long doctorId,
                                       @RequestBody Appointment appointment) {
        return appointmentService.bookAppointment(patientId, doctorId, appointment);
    }

    // Get all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Get appointment by ID
    @GetMapping("/{id}")
    public Appointment getAppointment(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    // Cancel appointment
    @PutMapping("/cancel/{id}")
    public String cancelAppointment(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
        return "Appointment cancelled successfully";
    }
}
