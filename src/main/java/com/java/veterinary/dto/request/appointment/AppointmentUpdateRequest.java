package com.java.veterinary.dto.request.appointment;

import com.java.veterinary.entity.Animal;
import com.java.veterinary.entity.Doctor;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentUpdateRequest {

    @Positive(message = "ID pozitif sayı olmalı")
    private long id;
    private LocalDateTime appointmentDate;
    private Long animalId;
    private Long doctorId;
}
