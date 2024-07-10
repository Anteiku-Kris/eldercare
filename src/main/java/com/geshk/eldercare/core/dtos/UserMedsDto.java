package com.geshk.eldercare.core.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
