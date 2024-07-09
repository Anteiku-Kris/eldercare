package com.geshk.eldercare.services;

import com.geshk.eldercare.entities.Users;
import com.geshk.eldercare.core.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface UserService {
     Users createUser(Users users);
     Optional<UserDto> getUser(int id);
     List<UserDto> getAllUsers();
     void deleteUser(int id);
     Users updateUser(Users users);

}
