package com.revature.training.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.revature.training.model.Doctor;

@EnableJpaRepositories
public interface DoctorRepository extends CrudRepository<Doctor, Integer>{
	
	//select * from doctor where doctorName=?
	public List<Doctor> findByDoctorName(String doctorName);
	
	//For login
	public Optional<Doctor> findByDoctorIdAndDoctorPassword(int doctorId, String password);
	
	//Getting details of doctor by domain
	public List<Doctor> findByDoctorDomain(String doctorDomain);

}
