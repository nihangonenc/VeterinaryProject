package com.java.veterinary.dto.request.vaccine;

import com.java.veterinary.entity.Animal;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineUpdateRequest {

    @Positive (message = "ID pozitif olmak zorunda")
    private long id;
    private String name;
    private String code;
    private Animal animal;
}
