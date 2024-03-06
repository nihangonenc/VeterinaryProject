package com.java.veterinary.business.concretes;

import com.java.veterinary.business.abstracts.IDoctorService;
import com.java.veterinary.core.exception.NotFoundException;
import com.java.veterinary.core.utilies.Msg;
import com.java.veterinary.dao.DoctorRepo;
import com.java.veterinary.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorManager implements IDoctorService {

    private final DoctorRepo doctorRepo;

    public DoctorManager(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public Doctor get(long id) {
        return this.doctorRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Doctor save(Doctor doctor) {  //DEĞERLENDİRME FORMU 15
        Optional<Doctor> isDoctorExist = doctorRepo.findByNameAndMail(doctor.getName(),doctor.getMail());
        if (isDoctorExist.isEmpty()) {
            return this.doctorRepo.save(doctor);
        }
        throw new RuntimeException("Bu Doktor Sistemde Kayıtlı");
    }

    @Override
    public Doctor update(Doctor doctor) {
        Optional<Doctor> isDoctorExist = doctorRepo.findById(doctor.getId());
        if (isDoctorExist.isEmpty()){
            throw new RuntimeException("Doktor Sistemde Bulunamadı");
        }
        this.get(doctor.getId());
        return this.doctorRepo.save(doctor);
    }

    @Override
    public Page<Doctor> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.doctorRepo.findAll(pageable);
    }

    @Override
    public String delete(long id) {
        Optional<Doctor> isDoctorExist = doctorRepo.findById(id);
        if (isDoctorExist.isEmpty()){
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        else {
            doctorRepo.delete(isDoctorExist.get());
            return Msg.OK;
        }
    }
}
