package com.geshk.eldercare.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserMeds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private Users userId;

    @Column(nullable = false)
    private String start;

    @Column(nullable = false)
    private String finish;

    @Column(nullable = false)
    private String frecuencia;

    @Column(nullable = false)
    private String dosis;

    @Column(nullable = false)
    private String instructions;

}
