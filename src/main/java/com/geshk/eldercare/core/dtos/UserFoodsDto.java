package com.geshk.eldercare.core.dtos;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFoodsDto {
    private int id;
    private int userId;
    private String name;
    private String description;
}
