package com.geshk.eldercare.core.dtos;

import com.geshk.eldercare.entities.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserMedsDto {

    private int id;
    private int userId;
    private String start;
    private String finish;
    private String frecuencia;
    private String dosis;
    private String instructions;

}
