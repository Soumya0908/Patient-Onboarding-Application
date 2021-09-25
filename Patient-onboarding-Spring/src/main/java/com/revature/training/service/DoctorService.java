package com.revature.training.service;

import java.util.List;

import com.revature.training.model.Doctor;
import com.revature.training.model.DoctorAvailability;

public interface DoctorService {
	public int addDoctor(Doctor doctor);
	public boolean deleteDoctor(int doctorId);
	public boolean updateDoctor(Doctor doctor);
	public Doctor getDoctorById(int doctorId);
	public List<Doctor> getDoctorByName(String doctorName);
	public List<Doctor> getAllDoctors();
	public boolean isDoctorExists(int doctorId);
	public boolean doctorLogin(int doctorId,String password);
	public boolean saveDoctorAvailability(DoctorAvailability doctorAvailability);
	public List<DoctorAvailability> getAvailabilitesByDoctorId(int doctorId);
	public Doctor viewDoctorDetails(int doctorId);
	public List<Doctor> getDoctorByDoctorDomain(String doctorDomain);
	public void updateDoctorStatus(Doctor doctor);

}
