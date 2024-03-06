package com.java.veterinary.dto.response;


import com.java.veterinary.entity.Appointment;
import com.java.veterinary.entity.AvailableDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponse {

    private long id;
    private String name;
    private String phone;
    private String mail;
    private String address;
    private String city;
    private List<AvailableDate> availableDateList;
    private List<Appointment> appointmentList;
}
