package com.geshk.eldercare.services;

import com.geshk.eldercare.entities.UserMeds;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsersMedService {
    UserMeds createUserMeds(UserMeds userMeds);
    Optional<UserMeds> getUserMeds(int id);
    List<UserMeds>getAllUserMeds();
    UserMeds updateUserMeds(UserMeds userMeds);

    //Se me olvidó el void (investiga el error)
    void deleteUserMeds(int id);


}
