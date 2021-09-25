package com.revature.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.revature.training.model.PatientBookings;
@EnableJpaRepositories
public interface PatientBookingRepository extends CrudRepository<PatientBookings, Integer>{
	@Query("SELECT p from PatientBookings p where patientId=:patientId")
	public List<PatientBookings> findByPatientId(int patientId);
	
	@Query("SELECT p from PatientBookings p where doctorId=:doctorId")
	public List<PatientBookings> findByDoctorId(int doctorId);
	
	//public PatientBookings findAPatientBookings();
	@Query("SELECT p from PatientBookings p where patientId=:patientId")
	public List<PatientBookings> getBookingByPatientId(@Param("patientId") int patientId);
	

	


}
