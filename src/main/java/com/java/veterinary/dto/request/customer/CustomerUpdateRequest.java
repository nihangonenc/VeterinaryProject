package com.java.veterinary.dto.request.customer;

import com.java.veterinary.entity.Animal;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequest {

    @Positive (message = "ID pozitif sayı olmalı")
    private long id;
    private String name;
    private String phone;
    @Email
    private String mail;
    private String address;
    private String city;

}
