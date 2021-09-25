package com.revature.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.training.model.Doctor;
import com.revature.training.model.DoctorAvailability;
import com.revature.training.repository.DoctorAvailabilityRepository;
import com.revature.training.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	DoctorAvailabilityRepository doctorAvailabilityRepository;

	@Override
	public int addDoctor(Doctor doctor) {
		System.out.println("##### add doctor is called - Service");
		doctorRepository.save(doctor);
		return doctor.getDoctorId();
	}

	@Override
	public boolean deleteDoctor(int doctorId) {
		doctorRepository.deleteById(doctorId);
		return true;
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		doctorRepository.save(doctor);
		return false;
	}

	@Override
	public Doctor getDoctorById(int doctorId) {
		Optional<Doctor> doctorData = doctorRepository.findById(doctorId);
		Doctor doctor = doctorData.get();
		return doctor;
	}

	@Override
	public List<Doctor> getDoctorByName(String doctorName) {
		return doctorRepository.findByDoctorName(doctorName);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return (List<Doctor>) doctorRepository.findAll();
	}

	@Override
	public boolean isDoctorExists(int doctorId) {
		Optional<Doctor> doctorData = doctorRepository.findById(doctorId);
		return doctorData.isPresent();
	}

	@Override
	public boolean doctorLogin(int doctorId, String password) {
		Optional<Doctor> doctorData = doctorRepository.findByDoctorIdAndDoctorPassword(doctorId, password);
		return doctorData.isPresent();
	}

	@Override
	public boolean saveDoctorAvailability(DoctorAvailability doctorAvailability) {
		doctorAvailabilityRepository.save(doctorAvailability);
		return false;
	}

	@Override
	public List<DoctorAvailability> getAvailabilitesByDoctorId(int doctorId) {
		doctorAvailabilityRepository.findById(doctorId);
		return null;
	}

	@Override
	public Doctor viewDoctorDetails(int doctorId) {
		Optional<Doctor> doctorData = doctorRepository.findById(doctorId);
		Doctor doctor = doctorData.get();
		return doctor;
	}

	@Override
	public List<Doctor> getDoctorByDoctorDomain(String doctorDomain) {
		return doctorRepository.findByDoctorDomain(doctorDomain);
	}

	@Override
	public void updateDoctorStatus(Doctor doctor) {
		doctorRepository.save(doctor);

	}

}
