package com.revature.training.service;

import java.util.List;
import com.revature.training.model.DoctorAvailability;


public interface DoctorAvailabilityService{

	public boolean addDoctorAvailability(DoctorAvailability doctorAvailability);
	
	public boolean updateDoctorAvailability(DoctorAvailability doctorAvailability);

	public List<DoctorAvailability> getAllAvailability();
	
	public List<DoctorAvailability> getDoctorAvailabilityByDoctorDomain(String doctorDomain);
	
	public List<DoctorAvailability> getDoctorByDoctorId(int doctorId);
	
	public List<DoctorAvailability> getDoctorBySerialNo(int serialNo);
	
	public boolean deleteById(int serialNo);

}
