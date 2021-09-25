package com.revature.training.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="doctors")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int doctorId;
	@Column
	private String doctorName;
	@Column(unique=true)
	private String doctorPassword;
	@Column
	private String gender;
	@Column(unique=true)
	private String doctorMobileNo;
	@Column(unique=true)
	private String doctorEmail;
	@Column
	private String doctorDomain;
	@Column
	private String doctorExperience;
	@Column
	private int doctorSalary;


}
