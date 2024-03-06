package com.java.veterinary.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table (name = "available_dates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "date_id", nullable = false)
    private long id;

    @Column (name = "available_date")
    private LocalDate availableDate;

    @ManyToOne
    @JoinColumn (name= "doctor_id")
    private Doctor doctor;
}
