package com.java.veterinary.dto.response;

import com.java.veterinary.entity.Animal;
import com.java.veterinary.entity.Doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {

    private long id;
    private LocalDateTime appointmentDate;
    private Animal animal;
    private Doctor doctor;
}
