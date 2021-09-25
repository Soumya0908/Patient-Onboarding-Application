package com.revature.training.service;

import java.util.List;

import com.revature.training.model.Patient;

public interface PatientService {
	public boolean addPatient(Patient patient);
	public boolean patientLogin(int patientId, String patientPassword);
	public boolean deletePatient(int patientId);
	public List<Patient> getAllPatients();
	public Patient getPatientById(long patientId);
	public boolean isPatientExists(long patientId);
	public boolean updatePatientDetails(Patient patient);

}
