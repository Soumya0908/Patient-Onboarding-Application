package com.revature.training.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.revature.training.model.Admin;
import com.revature.training.model.Doctor;
import com.revature.training.model.Patient;
import com.revature.training.service.AdminService;
import com.revature.training.service.DoctorService;
import com.revature.training.service.PatientService;

@RestController
@RequestMapping("/Admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	PatientService patientService;
	@Autowired
	AdminService adminService;

	// localhost:9095/admin/adminId/adminPassword
	@GetMapping("{adminId}/{adminPassword}")
	public ResponseEntity<Integer> getAdmin(@PathVariable("adminId") int adminId,
			@PathVariable("adminPassword") String adminPassword) {
		System.out.println(" Admin login is called ");
		System.out.println(adminId);
		ResponseEntity<Integer> responseEntity = null;
		int message;
		if (adminService.isAdminExist(adminId)) {
			if (adminService.adminLogin(adminId, adminPassword)) {
				message = 1;
				responseEntity = new ResponseEntity<Integer>(message, HttpStatus.OK);
			} else {
				message = 0;
				responseEntity = new ResponseEntity<Integer>(message, HttpStatus.OK);
			}

		} else {
			message = -1;
			responseEntity = new ResponseEntity<Integer>(message, HttpStatus.OK);
		}

		return responseEntity;
	}
	
	// get all doctors
			@GetMapping()
			public ResponseEntity<List<Doctor>> getAllDoctors() {
				ResponseEntity<List<Doctor>> responseEntity=null;
				List<Doctor> doctorList = doctorService.getAllDoctors();
				if(doctorList.size()==0) {
					responseEntity=new ResponseEntity<List<Doctor>>(doctorList,HttpStatus.OK);
				}
				else
					responseEntity=new ResponseEntity<List<Doctor>>(doctorList,HttpStatus.OK);
				return responseEntity;
			}
			
			// get all doctors
					@GetMapping("/patientDetails")
					public ResponseEntity<List<Patient>> getAllPatients() {
						ResponseEntity<List<Patient>> responseEntity=null;
						List<Patient> patientList = patientService.getAllPatients();
						if(patientList.size()==0) {
							responseEntity=new ResponseEntity<List<Patient>>(patientList,HttpStatus.OK);
						}
						else
							responseEntity=new ResponseEntity<List<Patient>>(patientList,HttpStatus.OK);
						return responseEntity;
					}
			
			//get doctor by id
			@GetMapping("{doctorId}")
			public ResponseEntity<Doctor> getDoctorById(@PathVariable("doctorId") int doctorId) {
				ResponseEntity<Doctor> responseEntity=null;
				Doctor doctor =new Doctor();
				if(doctorService.isDoctorExists(doctorId)) {
					doctor=doctorService.getDoctorById(doctorId);
					responseEntity=new ResponseEntity<Doctor> (doctor,HttpStatus.OK);
				}
				else
					responseEntity=new ResponseEntity<Doctor> (doctor,HttpStatus.OK);
				
				return responseEntity;

			}
			
			//http://localhost:9090/doctor/filterDoctorByDomain/dental
			
			@GetMapping("/filterDoctorByDomain/{doctorDomain}")
			public List<Doctor> getDoctorByName(@PathVariable("doctorDomain") String doctorDomain) {
				
				System.out.println("filterDoctorByDomain called...");
				return doctorService.getDoctorByDoctorDomain(doctorDomain);

			}
			
			
			//insert a doctor
			@PostMapping
			public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor) {
				ResponseEntity<String> responseEntity=null;
				int doctorId=doctor.getDoctorId();
				String message=null;
				if(doctorService.isDoctorExists(doctorId)) {
					message="Doctor with doctorId "+doctorId+" already exists";
					responseEntity =new ResponseEntity<String>(message,HttpStatus.OK);
				}
				
				else {
					doctorService.addDoctor(doctor);
					
					int doctorId1=doctor.getDoctorId();
					
					Doctor doctor1=doctorService.getDoctorById(doctorId1);
					String mail=doctor1.getDoctorEmail();
					 message=doctor1.getDoctorName() +", admin added your account successfully!\n"+
							 "\nDoctor ID:"+doctor1.getDoctorId() +
							"\n Use this login Id to view your account."
							 
							 +"\nThank you.";
					
					 BookingMailSend.sendMail(mail,"Doctor Registration :", message);
					
					message="Doctor with doctorId "+doctorId+" saved successfully";
					responseEntity =new ResponseEntity<String>(message,HttpStatus.OK);
				}
				
				System.out.println(doctor);
				return responseEntity;
				
			}
			//update a product
			@PutMapping
			public ResponseEntity<String> updateDoctor(@RequestBody Doctor doctor) {
				ResponseEntity<String> responseEntity=null;
				int doctorId=doctor.getDoctorId();
				String message=null;
				if(doctorService.isDoctorExists(doctorId)) {
					doctorService.updateDoctor(doctor);
				message="Doctor with doctorId "+doctorId+" Updated Successfully";
				responseEntity =new ResponseEntity<String>(message,HttpStatus.OK);
				}
				else {
					
					message="Doctor with doctorId "+doctorId+" not exist";
					responseEntity =new ResponseEntity<String>(message,HttpStatus.OK);
				}
				
				
				return responseEntity;
			}
			
			@DeleteMapping("{doctorId}")
			public ResponseEntity<String> deleteDoctor(@PathVariable("doctorId") int doctorId) {
				ResponseEntity<String> responseEntity=null;
				
				String message=null;
				if(doctorService.isDoctorExists(doctorId)) {
					doctorService.deleteDoctor(doctorId);
				message="Doctor with doctorId "+doctorId+" deleted Successfully";
				responseEntity =new ResponseEntity<String>(message,HttpStatus.OK);
				}
				else {
					
					message="Doctor with doctorId "+doctorId+" not exist";
					responseEntity =new ResponseEntity<String>(message,HttpStatus.OK);
				}
				
				
				return responseEntity;
			}

}
