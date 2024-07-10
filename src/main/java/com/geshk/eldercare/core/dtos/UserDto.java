package com.geshk.eldercare.core.dtos;

import com.geshk.eldercare.core.emuns.UserGender;
import com.geshk.eldercare.core.emuns.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private int id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String username;
    private UserRole role;
    private String birthday;
    private UserGender gender;
    private String password;
}
