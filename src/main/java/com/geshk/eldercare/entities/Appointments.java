package com.geshk.eldercare.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Ingrese el Id del usuario de otra forma cree uno nuevo")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private Users userId;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
    private Patients patientId;
    @NotEmpty(message = "Ingrese la fecha de la cita")
    @Column(nullable = false)
    private String date;
    @NotEmpty(message = "Ingrese la hora de la cita")
    @Column(nullable = false)
    private String time;
    @NotEmpty(message = "Ingrese la informacion de la cita")
    @Column(nullable = false)
    private String description;
    @Column(nullable = true)
    private String doctorName;
}
