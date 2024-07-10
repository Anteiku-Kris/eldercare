package com.geshk.eldercare.services;

import com.geshk.eldercare.core.dtos.UserMedsDto;
import com.geshk.eldercare.entities.UserMeds;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsersMedService {
    UserMedsDto createUserMeds(UserMeds userMeds);
    List<UserMedsDto> getUserMeds(int id);
    UserMedsDto updateUserMeds(UserMeds userMeds);

    //Se me olvidó el void (investiga el error)
    void deleteUserMeds(int id);


}
