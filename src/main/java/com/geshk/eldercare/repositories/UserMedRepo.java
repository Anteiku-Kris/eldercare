package com.geshk.eldercare.repositories;

import com.geshk.eldercare.entities.UserMeds;
import lombok.Generated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMedRepo extends JpaRepository<UserMeds,Integer> {

}
