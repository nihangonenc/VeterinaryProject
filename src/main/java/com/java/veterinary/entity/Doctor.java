package com.java.veterinary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "doctors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "doctor_id", nullable = false)
    private long id;

    @Column (name  ="doctor_name",nullable = false)
    private String name;

    @Column (name  ="doctor_phone")
    private String phone;

    @Column (name  ="doctor_mail")
    private String mail;

    @Column (name  ="doctor_address")
    private String address;

    @Column (name  ="doctor_city")
    private String city;

    @OneToMany (mappedBy = "doctor", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<AvailableDate> availableDateList;

    @OneToMany (mappedBy = "doctor", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Appointment> appointmentList;
}
