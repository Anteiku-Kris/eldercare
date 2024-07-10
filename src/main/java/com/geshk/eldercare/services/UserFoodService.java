package com.geshk.eldercare.services;

import com.geshk.eldercare.entities.UserFoods;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserFoodService {
    UserFoods createUserFoods(UserFoods userFoods);
    Optional<UserFoods>getUserFoods(int id);
}
