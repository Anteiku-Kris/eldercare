package com.geshk.eldercare.services.servicesimpl;

import com.geshk.eldercare.core.dtos.UserFoodsDto;
import com.geshk.eldercare.entities.UserFoods;
import com.geshk.eldercare.services.UserFoodsService;
import com.geshk.eldercare.repositories.UserFoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFoodsServiceImpl implements UserFoodsService {

    @Autowired
    private UserFoodsRepo userFoodsRepo;

    @Override
    public UserFoodsDto createUserFoods(UserFoods userFoods) {
        UserFoods savedUserFoods = userFoodsRepo.findById(userFoods.getId()).orElse(null);

        if (savedUserFoods != null) {
            return userFoodsDto(savedUserFoods);
        }
        userFoodsRepo.save(userFoods);

        return userFoodsDto(userFoods);
    }

    @Override
    public List<UserFoodsDto> getUserFoods(int userId) {
        return userFoodsRepo.findAll().stream()
                .filter(foods -> foods.getUserId() == userId)
                .map(this::userFoodsDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserFoodsDto updateUserFoods(UserFoods userFoods) {
        UserFoods savedUserFoods = userFoodsRepo.findById((userFoods.getId())).orElse(null);

        if(savedUserFoods == null){
            return null;
        }

        userFoodsRepo.save(userFoods);

        return userFoodsDto(userFoods);
    }

    @Override
    public void deleteUserFoods(int id) {
        userFoodsRepo.deleteById(id);
    }

    private UserFoodsDto userFoodsDto(UserFoods userFoods) {
        return UserFoodsDto.builder()
                .id(userFoods.getId())
                .name(userFoods.getName())
                .description(userFoods.getDescription())
                .build();
    }
}
