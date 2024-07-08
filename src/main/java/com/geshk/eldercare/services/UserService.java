package com.geshk.eldercare.services;

import com.geshk.eldercare.entities.Users;
import com.geshk.eldercare.utils.dtos.UserDto;
import com.geshk.eldercare.utils.emuns.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public Users createUser(Users users);
    public Optional<UserDto> getUser(int id);
    public List<UserDto> getAllUsers();
    public void deleteUser(int id);
    public Users updateUser(Users users);

}
