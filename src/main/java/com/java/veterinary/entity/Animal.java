package com.java.veterinary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "animals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "animal_id", nullable = false)
    private long id;

    @Column (name = "animal_name", nullable = false)
    private String name;

    @Column (name = "animal_species")
    private String species;

    @Column (name = "animal_breed")
    private String breed;

    @Column (name = "animal_gender")
    private String gender;

    @Column (name = "animal_colour")
    private String colour;

    @Column (name = "date_of_birth")
    private LocalDate dateOfBirth;

    @OneToMany (mappedBy = "animal", cascade = CascadeType.REMOVE)
    @JsonIgnore //toStringte döngüye girmemesi için
    private List<Vaccine> vaccineList;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "customer_id")
    private Customer customer;

    @OneToMany (mappedBy = "animal", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Appointment> appointmentList;

}
