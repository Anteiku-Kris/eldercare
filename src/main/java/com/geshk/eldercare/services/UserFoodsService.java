package com.geshk.eldercare.services;

import com.geshk.eldercare.core.dtos.UserFoodsDto;
import com.geshk.eldercare.entities.UserFoods;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserFoodsService {
    UserFoodsDto createUserFoods(UserFoods userFoods);
    List<UserFoodsDto> getUserFoods(int userId);
    UserFoodsDto  updateUserFoods(UserFoods userFoods);
    void deleteUserFoods(int id);
}
