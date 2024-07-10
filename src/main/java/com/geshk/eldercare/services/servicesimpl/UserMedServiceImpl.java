package com.geshk.eldercare.services.servicesimpl;

import com.geshk.eldercare.entities.UserMeds;
import com.geshk.eldercare.repositories.UserMedRepo;
import com.geshk.eldercare.services.UsersMedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserMedServiceImpl implements UsersMedService {
    @Autowired
    private UserMedRepo userMedRepo;

    @Override
    public UserMeds createUserMeds(UserMeds userMeds) {
        return userMedRepo.save(userMeds);
    }

    @Override
    public Optional<UserMeds> getUserMeds(int id) {
        return userMedRepo.findById(id);
    }

    @Override
    public List<UserMeds> getAllUserMeds() {
        return userMedRepo.findAll();
    }

    @Override
    public UserMeds updateUserMeds(UserMeds userMeds) {
        return userMedRepo.save(userMeds);
    }

    @Override
    public void deleteUserMeds(int id) {
        userMedRepo.deleteById(id);
    }
}
