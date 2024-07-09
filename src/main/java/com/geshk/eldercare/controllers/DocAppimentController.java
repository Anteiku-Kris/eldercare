package com.geshk.eldercare.controllers;

import com.geshk.eldercare.core.dtos.AppoimentDto;
import com.geshk.eldercare.entities.Appointments;
import com.geshk.eldercare.services.DocAppoimentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doc-appointments")
public class DocAppimentController {

    @Autowired
    private DocAppoimentService docAppoimentService;

    @GetMapping("/doctor/{id}")
    public ResponseEntity<List<AppoimentDto>> getAppointmentsByDocId(@PathVariable int id) {
        List<AppoimentDto> appointments = docAppoimentService.findByDocId(id);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/date/{date}/doctor/{id}")
    public ResponseEntity<List<AppoimentDto>> getAppointmentsByDateAndDocId(@PathVariable String date, @PathVariable int id) {
        List<AppoimentDto> appointments = docAppoimentService.findByDate(date, id);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable int id) {
        docAppoimentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<?> createAppointment(@Valid @RequestBody Appointments appointments, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        AppoimentDto createdAppointment = docAppoimentService.createAppoiment(appointments);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAppointment(@PathVariable int id, @Valid @RequestBody Appointments appointments, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        appointments.setId(id);
        AppoimentDto updatedAppointment = docAppoimentService.updateAppoiment(appointments);
        if (updatedAppointment != null) {
            return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Appointment not found", HttpStatus.NOT_FOUND);
        }
    }
}
