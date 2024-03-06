package com.java.veterinary.dto.request.availableDate;

import com.java.veterinary.entity.Doctor;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateUpdateRequest {

    @Positive (message = "ID pozitif sayı olmalı")
    private long id;
    private LocalDate availableDate;
    private Doctor doctor;
}
