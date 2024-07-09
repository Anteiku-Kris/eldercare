package com.geshk.eldercare.services.servicesimpl;

import com.geshk.eldercare.entities.Users;
import com.geshk.eldercare.repositories.UserRepo;
import com.geshk.eldercare.services.UserService;
import com.geshk.eldercare.core.dtos.UserDto;
import com.geshk.eldercare.core.emuns.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public Users createUser(Users users) {
        Users newUser = userRepo.findAllById(users.getId());

        if (newUser != null) {
            return newUser;
        }

        userRepo.save(buildUser(users));

        return buildUser(users);
    }

    @Override
    public Optional<UserDto> getUser(int id) {
        return userRepo.findById(id)
                .filter(user -> user.getRole() == UserRole.USER)
                .map(this::userDtoBuilder);
    }


    @Override
    public List<UserDto> getAllUsers() {
        return userRepo.findAll().stream()
                .filter(user -> user.getRole() == UserRole.USER)
                .map(this::userDtoBuilder)
                .collect(Collectors.toList());
    }



    @Override
    public void deleteUser(int id) {
        userRepo.findById(id)
                .filter(user -> user.getRole() == UserRole.DOCTOR)
                .ifPresent(userRepo::delete);
    }

    @Override
    public Users updateUser(Users users) {
        Users user = userRepo.findAllById(users.getId());

        if (user == null) {
            return null;
        }

        user = buildUser(users);
        user.setId(users.getId());

        userRepo.save(user);

        return user;
    }


    //Users Builder
    private Users buildUser(Users user){

        return Users.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .phone(user.getPhone())
                .address(user.getAddress())
                .lastname(user.getLastname())
                .photo(user.getPhoto())
                .gender(user.getGender())
                .username(user.getUsername())
                .birthday(user.getBirthday())
                .role(UserRole.USER)
                .build();
    }

    // DTO Builder
    private UserDto userDtoBuilder(Users user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastname())
                .email(user.getEmail())
                .phone(user.getPhone())
                .address(user.getAddress())
                .username(user.getUsername())
                .role(user.getRole())
                .birthday(user.getBirthday())
                .gender(user.getGender())
                .build();
    }
}
