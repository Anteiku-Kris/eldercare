package com.geshk.eldercare.controllers;


import com.geshk.eldercare.entities.Users;
import com.geshk.eldercare.services.DoctorService;
import com.geshk.eldercare.utils.dtos.UserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllDoctors() {
        List<UserDto> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getDoctor(@PathVariable int id) {
        Optional<UserDto> doctor = doctorService.getDoctor(id);
        return doctor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDoctor(@PathVariable int id, @Valid @RequestBody Users user, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        user.setId(id);
        Users updatedDoctor = doctorService.updateDoctor(user);
        if (updatedDoctor != null) {
            return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addDoctor(@Valid @RequestBody Users user, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Users savedDoctor = doctorService.createDoctor(user);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }
}
