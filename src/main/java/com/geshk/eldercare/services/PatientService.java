package com.geshk.eldercare.services;

import com.geshk.eldercare.core.dtos.PatientsDto;
import com.geshk.eldercare.entities.Patients;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PatientService {

     PatientsDto addPatient(Patients patient);
     PatientsDto updatePatient(Patients patient);
     void deletePatient(int id);
     Optional<PatientsDto> findByUsername(String dni);
     List<PatientsDto> getPatientByDoctor(int doctorId);

}
