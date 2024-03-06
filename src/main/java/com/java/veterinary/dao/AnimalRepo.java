package com.java.veterinary.dao;

import com.java.veterinary.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepo extends JpaRepository<Animal, Long> {
    Optional<Animal> findByNameAndSpeciesAndDateOfBirth(String name, String species, LocalDate dateOfBirth);
    List<Animal> findByNameIgnoreCase(String name); //İsme göre filtreleme
    List<Animal> findByCustomerId (Long id);
}
