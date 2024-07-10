package com.geshk.eldercare.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.geshk.eldercare.core.emuns.UserGender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "El Nombre no puede estar vacio")
    @Column(nullable = false)
    private String name;

    @NotEmpty(message = "El Apellido no puede estar vacio")
    @Column(nullable = false)
    private String lastname;

    @NotEmpty(message = "El DNI no puede estar vacio")
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    @NotEmpty(message = "Ingrese la edad")
    private int age;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserGender gender;

    @NotEmpty(message = "Ingrese una direccion de residencia")
    @Column(nullable = false)
    private String address;

    @NotEmpty(message = "Ingrese un numero de telefono")
    @Column(nullable = false)
    private String phone;

    @NotEmpty(message = "Ingrese un correo electronico")
    @Email(message = "Ingrese una direccion de correo valida")
    @Column(nullable = false)
    private String email;

    @NotEmpty(message = "Ingrese su fecha de nacimiento")
    @Column(nullable = false)
    private String birthday;

    @NotEmpty(message = "Ingrese el id doctor que genero la cita")
    private int doctorId;

    @NotEmpty(message = "Ingrese el id de la cita")
    private int appointments;

}
