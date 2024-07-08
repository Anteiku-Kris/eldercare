package com.geshk.eldercare.repositories;

import com.geshk.eldercare.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    public Users findAllById(int id);
}
