package com.geshk.eldercare.controllers;

import com.geshk.eldercare.core.dtos.UserFoodsDto;
import com.geshk.eldercare.entities.UserFoods;
import com.geshk.eldercare.entities.Users;
import com.geshk.eldercare.services.UserFoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userfoods")
public class UserFoodsController {
    @Autowired
    private UserFoodsService userFoodsService;

    @PostMapping
    public ResponseEntity<UserFoodsDto> createUserFoods(@RequestBody UserFoods userFoods){
        UserFoodsDto createdUserFoods = userFoodsService.createUserFoods(userFoods);
        return ResponseEntity.ok(createdUserFoods);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserFoodsDto>> getUserFoods(@PathVariable int userId){
        List<UserFoodsDto> userFoodsList = userFoodsService.getUserFoods(userId);
        return ResponseEntity.ok(userFoodsList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserFoodsDto> updateUserFoods(@PathVariable int id, @RequestBody UserFoods userFoods){
        userFoods.setId(id);

        UserFoodsDto updatedUserFoods = userFoodsService.updateUserFoods(userFoods);
        if(updatedUserFoods == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUserFoods);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserFoods(@PathVariable int id){
        userFoodsService.deleteUserFoods(id);
        return ResponseEntity.noContent().build();
    }
}
