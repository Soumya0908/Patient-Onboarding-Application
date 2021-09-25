package com.revature.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.training.model.DoctorAvailability;
import com.revature.training.repository.DoctorAvailabilityRepository;

@Service
public class DoctorAvailabilityServiceImpl implements DoctorAvailabilityService{
	@Autowired
	DoctorAvailabilityRepository doctorAvailabilityRepository;
	@Override
	public boolean addDoctorAvailability(DoctorAvailability doctorAvailability) {
		
		 doctorAvailabilityRepository.save(doctorAvailability);
		 return true;
	}

	@Override
	public boolean updateDoctorAvailability(DoctorAvailability doctorAvailability) {
		doctorAvailabilityRepository.save(doctorAvailability);
		 return true;
	}

	@Override
	public List<DoctorAvailability> getAllAvailability() {
		List<DoctorAvailability> availabilities=(List<DoctorAvailability>) doctorAvailabilityRepository.findAll();
		return availabilities;
	}

	@Override
	public List<DoctorAvailability> getDoctorAvailabilityByDoctorDomain(String doctorDomain) {
		List<DoctorAvailability> availabilities=(List<DoctorAvailability>) doctorAvailabilityRepository.getDoctorAvailabilityByDoctorDomain(doctorDomain);
		return availabilities;
	}

	@Override
	public List<DoctorAvailability> getDoctorByDoctorId(int doctorId) {
		List<DoctorAvailability> availabilities=(List<DoctorAvailability>) doctorAvailabilityRepository.findDoctorAvailabilityByDoctorId(doctorId);
		return availabilities;
	}
	@Override
	public List<DoctorAvailability> getDoctorBySerialNo(int serialNo) {
		return  doctorAvailabilityRepository.findDoctorAvailabilityBySerialNo(serialNo);
	}

	@Override
	public boolean deleteById(int serialNo) {
		doctorAvailabilityRepository.deleteById(serialNo);;
		return true;
	}

}
