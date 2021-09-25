package com.revature.training.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Table(name="admin")
@Data
 public class Admin {
	@Id
	private int adminId;
	private String  adminPassword;
	private String adminName;

}
