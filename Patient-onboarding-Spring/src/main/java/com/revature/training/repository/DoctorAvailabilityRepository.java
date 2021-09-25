package com.revature.training.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.revature.training.model.DoctorAvailability;
@EnableJpaRepositories
public interface DoctorAvailabilityRepository extends CrudRepository<DoctorAvailability, Integer>{
	@Query("SELECT a from DoctorAvailability a where doctor_Domain=:doctor_Domain")
	public List<DoctorAvailability> getDoctorAvailabilityByDoctorDomain(@Param("doctor_Domain") String doctorDomain);

	@Query("SELECT a from DoctorAvailability a where doctorId=:doctorId")
	public List<DoctorAvailability> findDoctorAvailabilityByDoctorId(@Param("doctorId") int doctorId);
	
	@Query("SELECT a from DoctorAvailability a where serialNo=:serialNo")
	public List<DoctorAvailability> findDoctorAvailabilityBySerialNo(@Param("serialNo") int serialNo);

	
}
