package com.java.veterinary.dto.request.doctor;

import com.java.veterinary.entity.Appointment;
import com.java.veterinary.entity.AvailableDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSaveRequest {

    @NotNull (message = "İsim boş bırakılamaz")
    private String name;
    private String phone;
    @Email
    private String mail;
    private String address;
    private String city;
    private List<AvailableDate> availableDateList;

}
