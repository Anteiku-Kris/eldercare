package com.geshk.eldercare.utils.masterclasses;


import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Appointment {
    private String date;
    private String time;
    private String description;
}
