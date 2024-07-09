package com.geshk.eldercare.services;

import com.geshk.eldercare.core.dtos.AppoimentDto;
import com.geshk.eldercare.entities.Appointments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DocAppoimentService {

     List<AppoimentDto> findByDocId (int id);
     List<AppoimentDto> findByDate(String date, int id);
     void deleteById(int id);
     AppoimentDto createAppoiment(Appointments appointments);
     AppoimentDto updateAppoiment(Appointments appointments);
}
