package com.geshk.eldercare.controllers;

import com.geshk.eldercare.entities.UserMeds;
import com.geshk.eldercare.services.UsersMedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api/usermeds")
public class UserMedsController {

    @Autowired
    private UsersMedService userMedsService;

    @PostMapping
    public ResponseEntity<UserMeds> createUserMeds(@RequestBody UserMeds userMeds){
        UserMeds newUserMeds = userMedsService.createUserMeds(userMeds);
        return ResponseEntity.ok(newUserMeds);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserMeds>> getUserMeds(@PathVariable int id) {
        Optional<UserMeds> userMeds = userMedsService.getUserMeds(id);
        return ResponseEntity.ok(userMeds);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserMeds> updateUserMeds(@PathVariable int id, @RequestBody UserMeds userMeds){
        userMeds.setId(id);
        UserMeds updatedUserMeds = userMedsService.updateUserMeds(userMeds);
        return ResponseEntity.ok(updatedUserMeds);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteUserMeds(@PathVariable int id){
        userMedsService.deleteUserMeds(id);
        return ResponseEntity.noContent().build();
    }

}