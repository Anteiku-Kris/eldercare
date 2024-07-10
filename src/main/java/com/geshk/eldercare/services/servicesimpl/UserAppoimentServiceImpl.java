package com.geshk.eldercare.services.servicesimpl;

import com.geshk.eldercare.core.dtos.AppoimentDto;
import com.geshk.eldercare.entities.Appointments;
import com.geshk.eldercare.repositories.AppoinmentRepo;
import com.geshk.eldercare.services.UserAppoimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAppoimentServiceImpl implements UserAppoimentService {

    @Autowired
    private AppoinmentRepo appoinmentRepo;


    @Override
    public List<AppoimentDto> getAppoimentsByUser(int userId) {
        return appoinmentRepo.findAll().stream()
                .filter(appointments -> appointments.getUserId() == userId)
                .map(this::userAppointmentsDto)
                .collect(Collectors.toList());
    }

    @Override
    public AppoimentDto addAppoiment(Appointments appointments) {
        Appointments newAppointments = appoinmentRepo.findById(appointments.getId());

        if (newAppointments != null) {
            return userAppointmentsDto(newAppointments);
        }

        appoinmentRepo.save(userAppointmentsBuilder(appointments));

        return userAppointmentsDto(appointments);
    }

    @Override
    public AppoimentDto updateAppoiment(Appointments appointments) {
        Appointments newAppointments = appoinmentRepo.findById(appointments.getId());

        if (newAppointments == null) {
            return null;
        }

        appoinmentRepo.save(userAppointmentsBuilder(appointments));
        return userAppointmentsDto(appointments);
    }

    @Override
    public void deleteAppoiment(int appoimentId) {
        appoinmentRepo.deleteById(appoimentId);
    }

    //User Appoiments Builder
    private Appointments userAppointmentsBuilder(Appointments appointments) {
        return Appointments.builder()
                .id(appointments.getId())
                .userId(appointments.getUserId())
                .date(appointments.getDate())
                .time(appointments.getTime())
                .doctorName(appointments.getDoctorName())
                .description(appointments.getDescription())
                .build();
    }

    private AppoimentDto userAppointmentsDto(Appointments appointments) {
        return AppoimentDto.builder()
                .id(appointments.getId())
                .userId(appointments.getUserId())
                .date(appointments.getDate())
                .time(appointments.getTime())
                .doctorName(appointments.getDoctorName())
                .description(appointments.getDescription())
                .build();
    }
}
