package com.geshk.eldercare.services;

import com.geshk.eldercare.core.dtos.AppoimentDto;
import com.geshk.eldercare.entities.Appointments;

import java.util.List;

public interface UserAppoimentService {

    List<AppoimentDto> getAppoimentsByUser(int userId);
    AppoimentDto addAppoiment(Appointments  appointments);
    AppoimentDto updateAppoiment(Appointments appointments);
    void deleteAppoiment(int appoimentId);

}
