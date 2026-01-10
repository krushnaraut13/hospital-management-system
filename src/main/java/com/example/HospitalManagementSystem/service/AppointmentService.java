package com.example.HospitalManagementSystem.service;

import java.util.List;
import com.example.HospitalManagementSystem.entity.Appointment;

public interface AppointmentService {

    Appointment bookAppointment(Long patientId, Long doctorId, Appointment appointment);

    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(Long id);

    void cancelAppointment(Long id);
}
