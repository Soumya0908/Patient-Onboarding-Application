package com.revature.training.service;

import java.util.List;

import com.revature.training.model.PatientBookings;

public interface PatientBookingService {
	public boolean addPatientBookings(PatientBookings patientBookings);
	public List<PatientBookings> viewBookings();
	public List<PatientBookings> getByPatientid(int patientId);
	public List<PatientBookings> viewBookings(int doctorId);
	public boolean deleteBooking(int serialNumber);
	public boolean updateBooking(PatientBookings patientBookings);
	public List<PatientBookings> getBookingByDoctorId(int doctorId);
}
