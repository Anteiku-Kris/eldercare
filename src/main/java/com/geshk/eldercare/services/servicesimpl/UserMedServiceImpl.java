package com.geshk.eldercare.services.servicesimpl;

import com.geshk.eldercare.core.dtos.UserMedsDto;
import com.geshk.eldercare.entities.UserMeds;
import com.geshk.eldercare.repositories.UserMedRepo;
import com.geshk.eldercare.services.UsersMedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserMedServiceImpl implements UsersMedService {
    @Autowired
    private UserMedRepo userMedRepo;

    @Override
    public UserMedsDto createUserMeds(UserMeds userMeds) {
        UserMeds savedUserMeds = userMedRepo.findById(userMeds.getId()).orElse(null);

        if (savedUserMeds != null) {
            return userAppointmentsDto(savedUserMeds);
        }

        userMedRepo.save(userMeds);

        return userAppointmentsDto(userMeds);
    }

    @Override
    public List<UserMedsDto> getUserMeds(int id) {
        return  userMedRepo.findAll().stream()
                .filter(appointments -> appointments.getUserId().equals(id))
                .map(this::userAppointmentsDto)
                .collect(Collectors.toList());
   }

    @Override
    public UserMedsDto updateUserMeds(UserMeds userMeds) {
        UserMeds savedUserMeds = userMedRepo.findById(userMeds.getId()).orElse(null);

        if (savedUserMeds == null) {
            return null;
        }

        userMedRepo.save(userMeds);

        return userAppointmentsDto(userMeds);
    }

    @Override
    public void deleteUserMeds(int id) {
        userMedRepo.deleteById(id);
    }


    //Builder Methods UserMeds


    private UserMedsDto userAppointmentsDto(UserMeds userMeds) {
        return UserMedsDto.builder()
                .id(userMeds.getId())
                .userId(userMeds.getUserId())
                .start(userMeds.getStart())
                .finish(userMeds.getFinish())
                .dosis(userMeds.getDosis())
                .frecuencia(userMeds.getFrecuencia())
                .instructions(userMeds.getInstructions())
                .build();

    }

}
