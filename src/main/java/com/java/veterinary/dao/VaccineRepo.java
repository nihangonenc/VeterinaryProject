package com.java.veterinary.dao;

import com.java.veterinary.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine, Long> {
    List<Vaccine> findByAnimalId(Long id); //bir hayvana ait tüm aşılar listelensin
    List <Vaccine> findByProtectionStartDateBetween(LocalDate startDate, LocalDate finishDate);
    Optional<Vaccine> findByNameAndCodeAndAnimalIdAndProtectionFinishDateGreaterThanEqual (String name, String code, Long id, LocalDate protectionStartDate);
}
