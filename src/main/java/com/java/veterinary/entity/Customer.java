package com.java.veterinary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "customer_id", nullable = false)
    private long id;

    @Column (name ="customer_name",nullable = false)
    private String name;

    @Column (name ="customer_phone")
    private String phone;

    @Column (name ="customer_mail")
    private String mail;

    @Column (name ="customer_address")
    private String address;

    @Column (name ="customer_city")
    private String city;

    @OneToMany (mappedBy = "customer", cascade = CascadeType.REMOVE) //müşteriyi silince hayvanları da silinsin
    @JsonIgnore
    private List<Animal> animalList;
}
