package com.revature.training.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.training.model.DoctorAvailability;
import com.revature.training.model.PatientBookings;
import com.revature.training.service.DoctorAvailabilityServiceImpl;
import com.revature.training.service.DoctorService;
import com.revature.training.service.PatientBookingService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("DoctorAvailability")
public class DoctorAvailabilityContoller {

	@Autowired
	DoctorAvailabilityServiceImpl doctorAvailabilityService;
	@Autowired
	DoctorService doctorService;
	@Autowired
	PatientBookingService patientBookingService;
	

	// get all doctors
	@GetMapping
	public ResponseEntity<List<DoctorAvailability>> getAllAvailability() {
		ResponseEntity<List<DoctorAvailability>> responseEntity = null;
		List<DoctorAvailability> availabilities = doctorAvailabilityService.getAllAvailability();
		if (availabilities.size() == 0) {
			responseEntity = new ResponseEntity<List<DoctorAvailability>>(availabilities, HttpStatus.OK);
		} else
			responseEntity = new ResponseEntity<List<DoctorAvailability>>(availabilities, HttpStatus.OK);
		return responseEntity;
	}

	// localhost:9090/doctoravailability/getDoctorAvailabilityByDomain/1

	@GetMapping("/getDoctorAvailabilityByDomain/{doctorDomain}")
	public List<DoctorAvailability> getDoctorAvailabilityByDoctorDomain(@PathVariable("doctorDomain") String doctorDomain) {
		System.out.println("getDoctorAvailabilityByDomain called...");
		return doctorAvailabilityService.getDoctorAvailabilityByDoctorDomain(doctorDomain);
	}

	@GetMapping("/searchDoctorAvailabilityById/{doctorId}")
	public List<DoctorAvailability> getDoctorByDoctorId(@PathVariable("doctorId") int doctorId) {
		System.out.println("getDoctorBySerialNo called...");
		return doctorAvailabilityService.getDoctorByDoctorId(doctorId);
	}

	@GetMapping("/searchPatientBookingsByDoctorId/{doctorId}")
	public ResponseEntity<List<PatientBookings>> getPatientBookings(@PathVariable("doctorId") int doctorId){
		ResponseEntity<List<PatientBookings>> responseEntity = null;
		List<PatientBookings> patientBookings = new ArrayList<PatientBookings>();
		if(doctorService.isDoctorExists(doctorId)) {
			patientBookings=patientBookingService.viewBookings(doctorId);
			responseEntity =new ResponseEntity<List<PatientBookings>>(patientBookings,HttpStatus.OK);
		}
		else {
			responseEntity = new ResponseEntity<List<PatientBookings>>(patientBookings, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping
	public ResponseEntity<String> addDoctorAvailability(@RequestBody DoctorAvailability doctorAvailability){
		ResponseEntity<String> responseEntity = null;
		String message= null;
		doctorAvailabilityService.addDoctorAvailability(doctorAvailability);
		message="Doctor with doctorId availability added successfully";
		responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
		return responseEntity;
		
	}
	
	@GetMapping("/getBookingsBydoctorId/{doctorId}")
	public List<PatientBookings> getBookingstByPatientId(@PathVariable("doctorId") int doctorId) {
		System.out.println("getBookingsByDoctorId called...");
		return patientBookingService.getBookingByDoctorId(doctorId);
	}
	
	@PutMapping
	public ResponseEntity<String> updateDoctorAvailability(@RequestBody DoctorAvailability doctorAvailability){
		ResponseEntity<String> responseEntity = null;
		String message= null;
		System.out.println("update availability is called");
		doctorAvailabilityService.updateDoctorAvailability(doctorAvailability);
		message="Doctor with doctorId availability updated successfully";
		responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
		return responseEntity;
		
	}
	
	@GetMapping("/getDoctorAvailabilityBySerialNo/{serialNo}")
	public List<DoctorAvailability> getDoctorBySerialNo(@PathVariable("serialNo") int serialNo) {
		System.out.println("getDoctorBySerialNo called...");
		return doctorAvailabilityService.getDoctorBySerialNo(serialNo);
	}
	
	@DeleteMapping("{serialNo}")
	public boolean deleteAvailabilityBySerialNo(@PathVariable("serialNo") int serialNo) {
		System.out.println("delete availability by serial No "+serialNo);
		return doctorAvailabilityService.deleteById(serialNo);
	}
}
