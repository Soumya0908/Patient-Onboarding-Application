package com.revature.training.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.training.model.Doctor;
import com.revature.training.model.DoctorAvailability;
import com.revature.training.service.DoctorService;

@RestController
@RequestMapping("Doctor")
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {
	@Autowired
	DoctorService doctorService;
	
	// 1) localhost:9095/doctor
	// 2) localhost:9095/doctor?doctorName=Aroma
	@GetMapping
	public ResponseEntity<List<Doctor>> getDoctors(@RequestParam(required = false) String doctorName){
		ResponseEntity<List<Doctor>> responseEntity = null;
		List<Doctor> doctors = new ArrayList<Doctor>();
		if(doctorName == null) {
			doctors = doctorService.getAllDoctors();
		}else {
			doctors = doctorService.getDoctorByName(doctorName);
		}
		if(doctors.size()==0) {
			responseEntity = new ResponseEntity<List<Doctor>>(doctors, HttpStatus.NO_CONTENT);

		}
		else {
			responseEntity = new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
			
		}
		System.out.println("All doctors called - controller");
		return responseEntity;
	}
	

	@GetMapping("{doctorId}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable("doctorId")int doctorId){
		System.out.println("Single doctor is called "+doctorId);
		ResponseEntity<Doctor> responseEntity = null;
		Doctor doctor = new Doctor();
		if(doctorService.isDoctorExists(doctorId)) {
			
			doctor = doctorService.getDoctorById(doctorId);
			System.out.println(doctor);
			responseEntity = new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
			
		}
		else {
			responseEntity = new ResponseEntity<Doctor>(doctor, HttpStatus.OK);

		}
		
		return responseEntity;
	}
	
	@GetMapping("d/{doctorName}")
	public ResponseEntity<List<Doctor>> getDoctorByName(@PathVariable("doctorName")String doctorName){
		ResponseEntity<List<Doctor>> responseEntity = null;
		List<Doctor> doctors = doctorService.getDoctorByName(doctorName);
		if(doctors.size()==0) {
			responseEntity = new ResponseEntity<List<Doctor>>(doctors, HttpStatus.NO_CONTENT);

		}
		else {
			System.out.println("getting all doctors by doctor name "+doctorName);
			responseEntity = new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
			
		}
		return responseEntity;
		
	}
	
	
	@DeleteMapping("{doctorId}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("doctorId")int doctorId) {
		ResponseEntity<String> responseEntity = null;
		String message = null;
		if(doctorService.isDoctorExists(doctorId)) {
			doctorService.deleteDoctor(doctorId);
			message = "Doctor with doctor id : "+ doctorId + " deleted successfully";
			responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
			
		}
		else {
			message = "Doctor with doctor id : "+ doctorId + " doesn't exist";
			responseEntity = new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);

		}
		return responseEntity;
	}
	@PutMapping
	public ResponseEntity<String> updateDoctor(@RequestBody Doctor doctor) {
		ResponseEntity<String> responseEntity = null;
		int doctorId = doctor.getDoctorId();
		String message = null;
		if(doctorService.isDoctorExists(doctorId)) {
			doctorService.updateDoctor(doctor);
			message = "Doctor with doctor id : "+ doctorId+ " updated successfully";
			System.out.println(message);
			responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
			
		}else {
			message = "Doctor with doctor id : "+ doctorId+ " doesn't exist";
			System.out.println(message);
			responseEntity = new ResponseEntity<String>(message,HttpStatus.NO_CONTENT);
			
		}
		return responseEntity;
	}
	
	@GetMapping("{doctorId}/{doctorPassword}")
	public ResponseEntity<Integer> getDoctor(@PathVariable("doctorId")int doctorId,@PathVariable("doctorPassword") String doctorPassword){
		System.out.println("Login is called ");
		ResponseEntity<Integer> responseEntity = null;
		int message;
		if(doctorService.isDoctorExists(doctorId)) {
			if(doctorService.doctorLogin(doctorId, doctorPassword)) {
				message = 1;
				responseEntity = new ResponseEntity<Integer>(message, HttpStatus.OK);
				
			}
			else {
				message = 0;
				responseEntity = new ResponseEntity<Integer>(message, HttpStatus.OK);
			}
		}
		else {
			message = -1;
			responseEntity = new ResponseEntity<Integer>(message, HttpStatus.OK);

		}
		return responseEntity;
	}
	
	@PostMapping("/doctorAvailability")
	public ResponseEntity<String> saveDoctorAvailability(@RequestBody DoctorAvailability doctorAvailability) {
		ResponseEntity<String> responseEntity = null;
		doctorService.saveDoctorAvailability(doctorAvailability);
		System.out.println(doctorAvailability);
		String message="Doctor availability saved successfully";
		responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/doctorAvailability/{{doctorId}}")
	public ResponseEntity<List<DoctorAvailability>> getDoctorAvailability(@PathVariable("doctorId")int doctorId){
		ResponseEntity<List<DoctorAvailability>> responseEntity = null;
		List<DoctorAvailability> doctorAvailability = doctorService.getAvailabilitesByDoctorId(doctorId);
		if(doctorAvailability.size()==0) {
			responseEntity = new ResponseEntity<List<DoctorAvailability>>(doctorAvailability, HttpStatus.NO_CONTENT);

		}
		else {
			System.out.println("getting doctor availability by doctor id "+doctorId);
			responseEntity = new ResponseEntity<List<DoctorAvailability>>(doctorAvailability, HttpStatus.OK);
			
		}
		return responseEntity;
		
	}
	
	
	 
}

