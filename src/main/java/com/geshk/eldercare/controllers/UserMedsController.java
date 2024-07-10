package com.geshk.eldercare.controllers;

import com.geshk.eldercare.core.dtos.UserMedsDto;
import com.geshk.eldercare.entities.UserMeds;
import com.geshk.eldercare.services.UsersMedService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/user-meds")
public class UserMedsController {

    @Autowired
    private UsersMedService usersMedService;

    @PostMapping
    public ResponseEntity<?> createUserMeds(@Valid @RequestBody UserMeds userMeds, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        UserMedsDto createdUserMeds = usersMedService.createUserMeds(userMeds);
        return new ResponseEntity<>(createdUserMeds, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<UserMedsDto>> getUserMeds(@PathVariable int id) {
        List<UserMedsDto> userMeds = usersMedService.getUserMeds(id);
        return new ResponseEntity<>(userMeds, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserMeds(@PathVariable int id, @Valid @RequestBody UserMeds userMeds, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        userMeds.setId(id);
        UserMedsDto updatedUserMeds = usersMedService.updateUserMeds(userMeds);
        if (updatedUserMeds != null) {
            return new ResponseEntity<>(updatedUserMeds, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User Medications not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserMeds(@PathVariable int id) {
        usersMedService.deleteUserMeds(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}