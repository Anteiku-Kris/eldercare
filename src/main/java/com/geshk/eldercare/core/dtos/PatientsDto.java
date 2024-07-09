package com.geshk.eldercare.core.dtos;

import com.geshk.eldercare.core.emuns.UserGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientsDto {


    private int id;

    private String name;

    private String lastname;

    private String username;

    private int age;

    private UserGender gender;

    private String address;

    private String phone;

    private String email;

    private String birthday;

    private int doctorId;
}
