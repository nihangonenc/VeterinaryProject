package com.java.veterinary.dao;


import com.java.veterinary.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByAppointmentDateAndAnimalIdAndDoctorId(LocalDateTime date, Long id, Long id1); //daha önce kayıtlı var mı?
    Optional<Appointment> findByDoctorIdAndAppointmentDate(Long id, LocalDateTime date);

    //tarih aralığına ve hayvana göre filtreleme:
    List<Appointment> findByAnimalIdAndAppointmentDateBetween (long animalId, LocalDateTime startDate, LocalDateTime finishDate);

    //tarih aralığına ve doktora göre filtreleme:
    List<Appointment> findByDoctorIdAndAppointmentDateBetween (long doctorId, LocalDateTime startDate, LocalDateTime finishDate);

}
