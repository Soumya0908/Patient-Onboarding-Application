package com.revature.training.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="doctors_availability")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorAvailability {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serialNo;
	
	@Column
	private int doctorId;
	
	
	@Basic
	@Temporal(TemporalType.DATE)
	private Date availableDate;
	
	
	@Basic
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern = "HH:mm")
	private Date availableTime;
	
	@Column
	private String status;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumns({
	 * 
	 * @JoinColumn(name="doctor_Id", referencedColumnName="doctorId"),
	 * 
	 * @JoinColumn(name="doctor_Name", referencedColumnName="doctorName"),
	 * 
	 * @JoinColumn(name="doctor_Domain", referencedColumnName="doctorDomain"),
	 * 
	 * @JoinColumn(name="doctor_Experience",
	 * referencedColumnName="doctorExperience")
	 * 
	 * }) private Doctor doctor;
	 */

	
	

}