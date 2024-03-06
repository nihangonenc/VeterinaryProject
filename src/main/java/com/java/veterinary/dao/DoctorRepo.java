package com.java.veterinary.dao;

import com.java.veterinary.entity.Doctor;
import com.java.veterinary.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByNameAndMail (String name, String mail);
}
