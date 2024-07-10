package com.geshk.eldercare.services.servicesimpl;


import com.geshk.eldercare.core.dtos.AppoimentDto;
import com.geshk.eldercare.entities.Appointments;
import com.geshk.eldercare.repositories.AppoinmentRepo;
import com.geshk.eldercare.services.DocAppoimentService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DocAppoimentServiceImpl implements DocAppoimentService {

    @Autowired
    private final AppoinmentRepo appoinmentRepo;


    @Override
    public List<AppoimentDto> findByDocId(int id) {
        return appoinmentRepo.findAll().stream()
                .filter(appointments -> appointments.getUserId() == id)
                .map(this::docAppointmentsDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppoimentDto> findByDate(String date, int id) {
        return appoinmentRepo.findAll().stream()
                .filter(appointments -> appointments.getDate().equals("Date") && appointments.getUserId() == id)
                .map(this::docAppointmentsDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        appoinmentRepo.deleteById(id);
    }

    @Override
    public AppoimentDto createAppoiment(Appointments appointments) {
        Appointments newAppointments = appoinmentRepo.findById(appointments.getId());

        if (newAppointments != null) {
            return docAppointmentsDto(newAppointments);
        }

        appoinmentRepo.save(docAppointmentsBuilder(appointments));

        return docAppointmentsDto(appointments);
    }

    @Override
    public AppoimentDto updateAppoiment(Appointments appointments) {
        Appointments newAppointments = appoinmentRepo.findById(appointments.getId());

        if (newAppointments == null) {
            return null;
        }

        appoinmentRepo.save(docAppointmentsBuilder(appointments));
        return docAppointmentsDto(appointments);
    }

    //DocAppoint Logic Methods

    private Appointments docAppointmentsBuilder(Appointments appointments) {
        return Appointments.builder()
                .time(appointments.getTime())
                .date(appointments.getDate())
                .description(appointments.getDescription())
                .patientId(appointments.getPatientId())
                .userId(appointments.getUserId())
                .build();
    }

    private AppoimentDto docAppointmentsDto(Appointments appointments) {
        return AppoimentDto.builder()
                .id(appointments.getId())
                .date(appointments.getDate())
                .description(appointments.getDescription())
                .time(appointments.getTime())
                .patientId(appointments.getPatientId())
                .build();
    }
}
