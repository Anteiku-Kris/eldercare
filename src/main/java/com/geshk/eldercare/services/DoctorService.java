package com.geshk.eldercare.services;

import com.geshk.eldercare.entities.Users;
import com.geshk.eldercare.utils.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DoctorService {
    public Users createDoctor(Users users);
    public Optional<UserDto> getDoctor(int id);
    public List<UserDto> getAllDoctors();
    public Users updateDoctor(Users users);
    public void deleteDoctor(int id);
}

