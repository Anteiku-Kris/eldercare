package com.geshk.eldercare.services;

import com.geshk.eldercare.entities.Users;
import com.geshk.eldercare.core.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DoctorService {
    UserDto createDoctor(Users users);
    Optional<UserDto> getDoctor(int id);
    List<UserDto> getAllDoctors();
    UserDto updateDoctor(Users users);
    void deleteDoctor(int id);
}

