package com.geshk.eldercare.services.servicesimpl;

import com.geshk.eldercare.entities.Users;
import com.geshk.eldercare.repositories.UserRepo;
import com.geshk.eldercare.services.DoctorService;
import com.geshk.eldercare.core.dtos.UserDto;
import com.geshk.eldercare.core.emuns.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createDoctor(Users users) {
        Users newDoctor = userRepo.findAllById(users.getId());

        if (newDoctor != null) {
            return userDtoBuilder(newDoctor);
        }

        userRepo.save(buildUser(users));

        return userDtoBuilder(users);
    }

    @Override
    public Optional<UserDto> getDoctor(int id) {
        return userRepo.findById(id)
                .filter(user -> user.getRole() == UserRole.DOCTOR)
                .map(this::userDtoBuilder);
    }

    @Override
    public List<UserDto> getAllDoctors() {
        return userRepo.findAll().stream()
                .filter(user -> user.getRole() == UserRole.DOCTOR)
                .map(this::userDtoBuilder)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateDoctor(Users users) {
        Users doctor = userRepo.findAllById(users.getId());

        if (doctor == null) {
            return null;
        }

        doctor = buildUser(users);
        doctor.setId(users.getId());

        userRepo.save(doctor);

        return userDtoBuilder(doctor);
    }

    @Override
    public void deleteDoctor(int id) {
        userRepo.findById(id)
                .filter(user -> user.getRole() == UserRole.DOCTOR)
                .ifPresent(userRepo::delete);
    }

    //Users Builder
    private Users buildUser(Users user) {

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
                .role(UserRole.DOCTOR)
                .build();
    }


    private UserDto userDtoBuilder(Users user) {
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
