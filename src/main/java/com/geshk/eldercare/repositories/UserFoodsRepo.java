package com.geshk.eldercare.repositories;

import com.geshk.eldercare.entities.UserFoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFoodsRepo extends JpaRepository<UserFoods, Integer>{

}