package com.geshk.eldercare.services;

import com.geshk.eldercare.core.dtos.AppoimentDto;

import java.util.List;

public interface UserAppoimentService {

    List<AppoimentDto> getAppoimentsByUser(int userId);
    AppoimentDto addAppoiment(AppoimentDto appoimentDto);
    AppoimentDto updateAppoiment(AppoimentDto appoimentDto);
    void deleteAppoiment(int appoimentId);

}
