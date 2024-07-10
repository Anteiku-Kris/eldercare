package com.geshk.eldercare.core.dtos;

import com.geshk.eldercare.entities.Patients;
import com.geshk.eldercare.entities.Users;
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
    private Patients patientId;
}
