package com.java.veterinary.dto.request.availableDate;

import com.java.veterinary.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateSaveRequest {

    private LocalDate availableDate;
    private Doctor doctor;
}
