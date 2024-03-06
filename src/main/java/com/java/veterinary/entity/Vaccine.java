package com.java.veterinary.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "vaccines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "vaccine_id", nullable = false)
    private long id;

    @Column (name = "vaccine_name", nullable = false)
    private String name;

    @Column (name = "vaccine_code", nullable = false)
    private String code;

    @Column (name = "protection_start_date", nullable = false)
    private LocalDate protectionStartDate;

    @Column (name = "protection_finish_date", nullable = false)
    private LocalDate protectionFinishDate;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "animal_id")
    private Animal animal;

}
