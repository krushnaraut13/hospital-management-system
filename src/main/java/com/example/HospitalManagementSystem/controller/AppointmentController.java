package com.example.HospitalManagementSystem.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.HospitalManagementSystem.entity.Appointment;
import com.example.HospitalManagementSystem.service.AppointmentService;
import com.example.HospitalManagementSystem.util.AuthorizationUtil;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // Book Appointment
    @PostMapping("/patient/{patientId}/doctor/{doctorId}")
    public Appointment bookAppointment(@RequestHeader("role") String role,
    		                           @PathVariable Long patientId,
                                       @PathVariable Long doctorId,
                                       @RequestBody Appointment appointment) {
        AuthorizationUtil.checkRole(role, "RECEPTIONIST");
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

    @GetMapping("/by-date")
    public List<Appointment> getAppointmentsByDate(
            @RequestParam String date) {

        LocalDate appointmentDate = LocalDate.parse(date);
        return appointmentService.getAppointmentsByDate(appointmentDate);
    }
    
    // Cancel appointment
    @PutMapping("/cancel/{id}")
    public String cancelAppointment(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
        return "Appointment cancelled successfully";
    }
}
