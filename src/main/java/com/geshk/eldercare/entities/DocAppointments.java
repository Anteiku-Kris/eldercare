package com.geshk.eldercare.entities;

import com.geshk.eldercare.utils.masterclasses.Appointment;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocAppointments extends Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int doctorId;
    @Column(nullable = false)
    private int patientId;

}
