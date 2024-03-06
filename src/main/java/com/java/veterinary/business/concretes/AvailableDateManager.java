package com.java.veterinary.business.concretes;

import com.java.veterinary.business.abstracts.IAvailableDateService;
import com.java.veterinary.core.exception.NotFoundException;
import com.java.veterinary.core.utilies.Msg;
import com.java.veterinary.dao.AvailableDateRepo;
import com.java.veterinary.entity.AvailableDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AvailableDateManager implements IAvailableDateService {
    private final AvailableDateRepo availableDateRepo;

    public AvailableDateManager(AvailableDateRepo availableDateRepo) {
        this.availableDateRepo = availableDateRepo;
    }

    @Override
    public AvailableDate get(long id) {
        return this.availableDateRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public AvailableDate save(AvailableDate availableDate) {  //DEĞERLENDİRME FORMU 16
        Optional<AvailableDate> isDateExist = this.findByAvailableDateAndDoctorId(availableDate.getAvailableDate(),availableDate.getDoctor().getId());
        if (isDateExist.isEmpty()) {
            return this.availableDateRepo.save(availableDate);
        }
        throw new RuntimeException("Bu Gün Sistemde Kayıtlı");
    }

    @Override
    public AvailableDate update(AvailableDate availableDate) {
        Optional<AvailableDate> isDateExist = availableDateRepo.findById(availableDate.getId());
        if (isDateExist.isEmpty()){
            throw new RuntimeException("Gün Sistemde Bulunamadı");
        }
        this.get(availableDate.getId());
        return this.availableDateRepo.save(availableDate);
    }

    @Override
    public Page<AvailableDate> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.availableDateRepo.findAll(pageable);
    }

    @Override
    public String delete(long id) {
        Optional<AvailableDate> isDateExist = availableDateRepo.findById(id);
        if (isDateExist.isEmpty()){
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        else {
            availableDateRepo.delete(isDateExist.get());
            return Msg.OK;
        }
    }

    @Override
    public Optional<AvailableDate> findByAvailableDateAndDoctorId(LocalDate availableDate, Long id) {
        return this.availableDateRepo.findByAvailableDateAndDoctorId(availableDate,id);
    }
}
