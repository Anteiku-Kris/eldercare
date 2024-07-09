package com.geshk.eldercare.repositories;

import com.geshk.eldercare.entities.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppoinmentRepo extends JpaRepository<Appointments, Integer> {

     List<Appointments> findByUserId(int docId);
     Appointments findById(int appointmentId);
}
