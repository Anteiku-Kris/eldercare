package com.geshk.eldercare.controllers;


import com.geshk.eldercare.core.dtos.PatientsDto;
import com.geshk.eldercare.entities.Patients;
import com.geshk.eldercare.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/patients")
@Validated
public class PatientsController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/{username}")
    public ResponseEntity<PatientsDto> getPatientByUsername( @PathVariable String username) {
        Optional<PatientsDto> patient = patientService.findByUsername(username);
        return patient.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient( @PathVariable int id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatient( @PathVariable int id, @Valid @RequestBody Patients patients, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        patients.setId(id);
        PatientsDto updatedPatient = patientService.updatePatient(patients);
        if (updatedPatient != null) {
            return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Paciente no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addPatient( @Valid @RequestBody Patients patients, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        PatientsDto savedPatient = patientService.addPatient(patients);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<PatientsDto>> getPatientsByDoctor( @PathVariable int doctorId) {
        List<PatientsDto> patients = patientService.getPatientByDoctor(doctorId);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
}
