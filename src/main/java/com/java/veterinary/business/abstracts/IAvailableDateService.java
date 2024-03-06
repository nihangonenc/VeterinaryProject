package com.java.veterinary.business.abstracts;

import com.java.veterinary.entity.AvailableDate;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.Optional;

public interface IAvailableDateService {
    AvailableDate get(long id);
    AvailableDate save(AvailableDate availableDate);
    AvailableDate update(AvailableDate availableDate);
    Page<AvailableDate> cursor(int page, int pageSize);
    String delete(long id);
    Optional<AvailableDate> findByAvailableDateAndDoctorId(LocalDate availableDate, Long id);
}
