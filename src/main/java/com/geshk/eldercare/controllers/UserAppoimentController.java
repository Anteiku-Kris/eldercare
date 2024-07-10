package com.geshk.eldercare.controllers;


import com.geshk.eldercare.core.dtos.AppoimentDto;
import com.geshk.eldercare.entities.Appointments;
import com.geshk.eldercare.services.UserAppoimentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-appointments")
public class UserAppoimentController {

    @Autowired
    private UserAppoimentService userAppoimentService;

    @GetMapping("/user/{id}")
    public ResponseEntity<List<AppoimentDto>> getAppointmentsByUserId(@PathVariable int id) {
        List<AppoimentDto> appointments = userAppoimentService.getAppoimentsByUser(id);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createAppointment(@Valid @RequestBody Appointments appointments, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        AppoimentDto createdAppointment = userAppoimentService.addAppoiment(appointments);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAppointment(@PathVariable int id, @Valid @RequestBody Appointments appointments, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        appointments.setId(id);
        AppoimentDto updatedAppointment = userAppoimentService.updateAppoiment(appointments);
        if (updatedAppointment != null) {
            return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Appointment not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable int id) {
        userAppoimentService.deleteAppoiment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
