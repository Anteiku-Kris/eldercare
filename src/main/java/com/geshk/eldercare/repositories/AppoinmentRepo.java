package com.geshk.eldercare.repositories;

import com.geshk.eldercare.entities.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocAppoinmentRepo extends JpaRepository<Appointments, Integer> {

    public List<Appointments> findByDocId(int docId);
}
