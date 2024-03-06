package com.java.veterinary.business.abstracts;

import com.java.veterinary.core.result.ResultData;
import com.java.veterinary.dto.response.AppointmentResponse;
import com.java.veterinary.entity.Appointment;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

public interface IAppointmentService {
    Appointment get(long id);
    Appointment save(Appointment appointment);
    Appointment update(Appointment appointment);
    Page<Appointment> cursor(int page, int pageSize);
    String delete(long id);

    ResultData<List<AppointmentResponse>> getByDoctorAndDate (long doctorId, LocalDateTime startDate, LocalDateTime finishDate);
    ResultData<List<AppointmentResponse>> getByAnimalAndDate (long animalId, LocalDateTime startDate, LocalDateTime finishDate);
}
