package com.revature.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.training.model.PatientBookings;
import com.revature.training.repository.PatientBookingRepository;

@Service
public class PatientBookingServiceImpl implements PatientBookingService {
		
		@Autowired
		PatientBookingRepository patientBookingsRepository;

		@Override
		public List<PatientBookings> viewBookings() {
			// TODO Auto-generated method stub
			return (List<PatientBookings>) patientBookingsRepository.findAll();
		}

		

		@Override
		public List<PatientBookings> viewBookings(int doctorId) {
			
			return patientBookingsRepository.findByDoctorId(doctorId);
		}

		@Override
		public boolean addPatientBookings(PatientBookings patientBookings) {
			 patientBookingsRepository.save(patientBookings);
			 return true;
			
		}


		@Override
		public boolean updateBooking(PatientBookings patientBookings) {
			patientBookingsRepository.save(patientBookings);
			return true;
		}

		@Override
		public List<PatientBookings> getBookingByDoctorId(int doctorId) {
			List<PatientBookings> bookingData = (List<PatientBookings>)patientBookingsRepository.findByDoctorId(doctorId);
			return bookingData;
		}

		@Override
		public boolean deleteBooking(int serialNumber) {
			patientBookingsRepository.deleteById(serialNumber);
			return true;
		}



		@Override
		public List<PatientBookings> getByPatientid(int patientId) {
			List<PatientBookings> bookingData = (List<PatientBookings>)patientBookingsRepository.findByPatientId(patientId);
			return bookingData;
		}
	}


