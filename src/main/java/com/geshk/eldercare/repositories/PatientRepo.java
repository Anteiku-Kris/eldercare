package com.geshk.eldercare.repositories;

import com.geshk.eldercare.entities.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patients, Integer> {

    public Patients findByUsername(String dni);

}


