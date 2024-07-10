package com.geshk.eldercare.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.geshk.eldercare.core.emuns.UserGender;
import com.geshk.eldercare.core.emuns.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
public class Users {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(unique = true, nullable = false, updatable = false)
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

    @NotEmpty(message = "Tiene que ingresar una contrasena")
    @Size(min = 8, message = "La contrasena debe tener almenos 8 caracteres")
    @Column(nullable = false)
    private String password;

    @NotEmpty(message = "Ingrese un correo electronico")
    @Email(message = "Ingrese una direccion de correo valida")
    @Column(nullable = false)
    private String email;

    @NotEmpty(message = "Ingrese un numero de telefono")
    @Column(nullable = false)
    private String phone;

    @NotEmpty(message = "Ingrese una direccion de residencia")
    @Column(nullable = false)
    private String address;

    @NotEmpty(message = "Ingrese su fecha de nacimiento")
    @Column(nullable = false)
    private String birthday;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserGender gender;

    private String photo;



    // Doctor Relations
    @JsonIgnoreProperties({"hibernateLazyInitializes", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorId")
    private List<Appointments> appointments;

    @JsonIgnoreProperties({"hibernateLazyInitializes", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorId")
    private List<Patients> docPatients;

    @JsonIgnoreProperties({"hibernateLazyInitializes", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private List<UserMeds> userMeds;
}
