package com.geshk.eldercare.services.servicesimpl;

import com.geshk.eldercare.core.dtos.PatientsDto;
import com.geshk.eldercare.entities.Patients;
import com.geshk.eldercare.repositories.PatientRepo;
import com.geshk.eldercare.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Override
    public PatientsDto addPatient(Patients patient) {
        Patients newPatient = patientRepo.findByUsername(patient.getUsername());

        if (newPatient != null) {
            return patientDtoBuilder(patient);
        }

        patientRepo.save(patientBuilder(patient));

        return patientDtoBuilder(patient);
    }

    @Override
    public PatientsDto updatePatient(Patients patient) {
        Patients newPatient = patientRepo.findByUsername(patient.getUsername());

        if (newPatient == null) {
            return null;
        }

        patient = patientBuilder(patient);
        patient.setId(patient.getId());

        patientRepo.save(patient);

        return patientDtoBuilder(patient);
    }

    @Override
    public void deletePatient(int id) {
        patientRepo.findById(id)
                .ifPresent(patientRepo::delete);
    }

    @Override
    public Optional<PatientsDto> findByUsername(String dni) {
        return Optional.ofNullable(patientDtoBuilder(patientRepo.findByUsername(dni)));
    }

    @Override
    public List<PatientsDto> getPatientByDoctor(int doctorId) {
        return patientRepo.findById(doctorId)
                .stream()
                .filter(patient -> patient.getDoctorId() == doctorId)
                .map(this::patientDtoBuilder)
                .collect(Collectors.toList());
    }


    // Patients logic methods

    private Patients patientBuilder(Patients patients) {
        return Patients.builder()
                .name(patients.getName())
                .lastname(patients.getLastname())
                .age(patients.getAge())
                .phone(patients.getPhone())
                .email(patients.getEmail())
                .address(patients.getAddress())
                .doctorId(patients.getDoctorId())
                .gender(patients.getGender())
                .birthday(patients.getBirthday())
                .build();
    }

    ;

    private PatientsDto patientDtoBuilder(Patients patients) {
        return PatientsDto.builder()
                .id(patients.getId())
                .username(patients.getUsername())
                .age(patients.getAge())
                .address(patients.getAddress())
                .phone(patients.getPhone())
                .name(patients.getName())
                .lastname(patients.getLastname())
                .email(patients.getEmail())
                .build();
    }

}
