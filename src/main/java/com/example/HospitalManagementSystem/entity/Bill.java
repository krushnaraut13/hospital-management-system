package com.example.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    private double consultationFee;
    private double medicineCharges;
    private double labCharges;
    private double totalAmount;

    private String paymentMode;   // CASH / CARD / UPI
    private String paymentStatus; // PAID / UNPAID

    private LocalDate billDate;

    //ONE appointment → ONE bill
    //One appointment produces only one bill and Prevents duplicate billing
    @OneToOne
    @JoinColumn(name = "appointment_id", nullable = false, unique = true)
    private Appointment appointment;

    public Bill() {
        this.billDate = LocalDate.now();
    }

    //Calculate total automatically
    public void calculateTotal() {
        this.totalAmount = consultationFee + medicineCharges + labCharges;
    }

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public double getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}

	public double getMedicineCharges() {
		return medicineCharges;
	}

	public void setMedicineCharges(double medicineCharges) {
		this.medicineCharges = medicineCharges;
	}

	public double getLabCharges() {
		return labCharges;
	}

	public void setLabCharges(double labCharges) {
		this.labCharges = labCharges;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
   
}
