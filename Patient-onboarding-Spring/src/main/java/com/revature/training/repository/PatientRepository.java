package com.revature.training.repository;


import java.util.Optional;


import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;


import com.revature.training.model.Patient;

@EnableJpaRepositories
public interface PatientRepository extends CrudRepository<Patient, Integer>{
	
	
	public Optional<Patient> findByPatientIdAndPassword(int patientId, String patientPassword);

}
