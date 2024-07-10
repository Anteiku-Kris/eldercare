package com.geshk.eldercare.controllers;

import com.geshk.eldercare.entities.UserFoods;
import com.geshk.eldercare.services.UserFoodService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userfoods")
public class UserFoodsController {
    @Autowired
    private UserFoodService userFoodService;

    @PostMapping
    public ResponseEntity<UserFoods> createUserFoods(@RequestBody UserFoods userFoods) {
        UserFoods newUserFoods = userFoodService.createUserFoods(userFoods);
        return ResponseEntity.ok(newUserFoods);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserFoods>> getUserFoods(@PathVariable int id) {
        Optional<UserFoods> userFoods = userFoodService.getUserFoods(id);
        return ResponseEntity.ok(userFoods);
    }

    @GetMapping
    public ResponseEntity<List<UserFoods>> getAllUserFoods() {
        List<UserFoods> userFoodsList = userFoodService.getAllUserFoods();
        return ResponseEntity.ok(userFoodsList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserFoods> updateUserFoods(@PathVariable int id, @RequestBody UserFoods userFoods){
        userFoods.setId(id);
        UserFoods updatedUserFoods = userFoodService.updateUserFoods(userFoods);
        return ResponseEntity.ok(updatedUserFoods);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteUserFoods(@PathVariable int id){
        userFoodService.deleteUserFood(id);
        return ResponseEntity.noContent().build();
    }

}
