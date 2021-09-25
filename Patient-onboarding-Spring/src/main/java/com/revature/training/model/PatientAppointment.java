package com.revature.training.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name="patientappointment")
@Data
public class PatientAppointment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serialNumber;
	private int patientId;
	private String patientName;
	private int patientAge;
	private int doctorId;
	private String doctorName;
	private String doctorDomain;
	private String doctorExperience;
	private String doctorMobileNo;
	
	@Basic
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(style = "hh:mm")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm")
	private Date availableTime;
	
	@Basic
	@Temporal(TemporalType.DATE)
	private Date availableDate;
}
