package com.geshk.eldercare.services.servicesimpl;

import com.geshk.eldercare.entities.UserFoods;
import com.geshk.eldercare.repositories.UserFoodsRepo;
import com.geshk.eldercare.services.UserFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserFoodImpl implements UserFoodService {
    @Autowired
    private UserFoodsRepo userFoodsRepo;

    @Override
    public UserFoods createUserFoods(UserFoods userFoods) {
        return userFoodsRepo.save(userFoods);
    }

    @Override
    public Optional<UserFoods> getUserFoods(int id) {
        return userFoodsRepo.findById(id);
    }

    @Override
    public List<UserFoods> getAllUserFoods() {
        return userFoodsRepo.findAll();
    }

    @Override
    public UserFoods updateUserFoods(UserFoods userFoods) {
        return userFoodsRepo.save(userFoods);
    }

    @Override
    public void deleteUserFood(int id) {
        userFoodsRepo.deleteById(id);
    }
}
