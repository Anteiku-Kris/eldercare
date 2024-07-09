package com.geshk.eldercare.core.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppoimentDto {

    private int id;
    private String date;
    private String time;
    private String description;
    private String doctorName;
    private int userId;
    private int patientId;
}
