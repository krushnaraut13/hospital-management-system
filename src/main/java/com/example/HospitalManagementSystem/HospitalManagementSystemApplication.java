package com.example.HospitalManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.HospitalManagementSystem")
@EntityScan("com.example.HospitalManagementSystem")
public class HospitalManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementSystemApplication.class, args);
	}

}
/*

1️⃣ Real-World Working of This Hospital Management System

A Hospital Management System is a software application used to digitally manage hospital operations, such as:

Patient records
Doctor information
Appointments
Prescription
Billing and payments

🔹 STEP 1: Patient Registration
1=A patient comes to the hospital → registration desk
  Receptionist enters patient details into system.
  POST /api/patients

🔹 STEP 2: Doctor Management
2=Hospital admin manages doctor details.
  POST /api/doctors
  GET /api/doctors

🔹 STEP 3: Appointment Booking
3=Patient books an appointment with a doctor
  Patient chooses a doctor and books a time slot.
  POST /api/appointments/patient/{patientId}/doctor/{doctorId}

🔹 STEP 4: Doctor Consultation
4=Doctor consults the patient and the doctor writes a prescription
  POST /api/prescriptions/appointment/{appointmentId}
🔹 STEP 5: Billing System
5=After consultation, billing desk generate the bill.
  POST /api/bills/appointment/{appointmentId}

6=Patient pays the bill

*/