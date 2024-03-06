package com.java.veterinary.business.concretes;

import com.java.veterinary.business.abstracts.IAppointmentService;
import com.java.veterinary.business.abstracts.IAvailableDateService;
import com.java.veterinary.core.config.modelMapper.IModelMapperService;
import com.java.veterinary.core.exception.NotFoundException;
import com.java.veterinary.core.result.ResultData;
import com.java.veterinary.core.utilies.Msg;
import com.java.veterinary.core.utilies.ResultHelper;
import com.java.veterinary.dao.AppointmentRepo;
import com.java.veterinary.dto.response.AppointmentResponse;
import com.java.veterinary.entity.Appointment;
import com.java.veterinary.entity.AvailableDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentManager implements IAppointmentService {
    private final AppointmentRepo appointmentRepo;
    private final IModelMapperService modelMapper;
    private final IAvailableDateService availableDateService;

    public AppointmentManager(AppointmentRepo appointmentRepo, IModelMapperService modelMapper, IAvailableDateService availableDateService) {
        this.appointmentRepo = appointmentRepo;
        this.modelMapper = modelMapper;
        this.availableDateService = availableDateService;
    }

    @Override
    public Appointment get(long id) {
        return this.appointmentRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Appointment save(Appointment a) {  //DEĞERLENDİRME FORMU 17-18

        if (a.getAppointmentDate().getMinute() != 0){
            throw new RuntimeException("Saat Başı Randevu Verilebilmektedir.");
        }

        Optional<Appointment> appointmentExist = appointmentRepo.findByAppointmentDateAndAnimalIdAndDoctorId(a.getAppointmentDate(), a.getAnimal().getId(), a.getDoctor().getId());
        if (appointmentExist.isPresent()) {
            throw new RuntimeException("Bu Randevu Sistemde Kayıtlı");
        }

        Optional<Appointment> appointmentExists = appointmentRepo.findByDoctorIdAndAppointmentDate(a.getDoctor().getId(), a.getAppointmentDate());
        if (appointmentExists.isPresent()) {
            throw new RuntimeException("Doktorun Bu Randevu Saati Dolu");
        }

        Optional<AvailableDate> availableDateExist = availableDateService.findByAvailableDateAndDoctorId(a.getAppointmentDate().toLocalDate(), a.getDoctor().getId());
        if (availableDateExist.isEmpty()) {
            throw new RuntimeException("Doktor Bu Gün Çalışmıyor");
        }

        return this.appointmentRepo.save(a);
    }


    @Override
    public Appointment update(Appointment appointment) {
        Optional<Appointment> isAppointmentExist = appointmentRepo.findById(appointment.getId());
        if (isAppointmentExist.isEmpty()) {
            throw new RuntimeException("Randevu Sistemde Bulunamadı");
        }
        this.get(appointment.getId());
        return this.appointmentRepo.save(appointment);
    }

    @Override
    public Page<Appointment> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.appointmentRepo.findAll(pageable);
    }

    @Override
    public String delete(long id) {
        Optional<Appointment> isAppointmentExist = appointmentRepo.findById(id);
        if (isAppointmentExist.isEmpty()) {
            throw new NotFoundException(Msg.NOT_FOUND);
        } else {
            appointmentRepo.delete(isAppointmentExist.get());
            return Msg.OK;
        }
    }

    @Override
    public ResultData<List<AppointmentResponse>> getByDoctorAndDate  //DEĞERLENDİRME FORMU 20
            (long doctorId, LocalDateTime startDate, LocalDateTime finishDate) {
        List<Appointment> appointments =
                this.appointmentRepo.findByDoctorIdAndAppointmentDateBetween(doctorId, startDate, finishDate);
        List<AppointmentResponse> appointmentResponse = appointments.stream().
                map(appointment -> this.modelMapper.forResponse().map(appointment, AppointmentResponse.class)).
                collect(Collectors.toList());
        if (appointments.isEmpty()) {
            return ResultHelper.notFound(appointmentResponse);
        } else {
            return ResultHelper.success(appointmentResponse);
        }
    }

    @Override
    public ResultData<List<AppointmentResponse>> getByAnimalAndDate //DEĞERLENDİRME FORMU 19
            (long animalId, LocalDateTime startDate, LocalDateTime finishDate) {
        List<Appointment> appointments =
                this.appointmentRepo.findByAnimalIdAndAppointmentDateBetween(animalId, startDate, finishDate);
        List<AppointmentResponse> appointmentResponse = appointments.stream().
                map(appointment -> this.modelMapper.forResponse().map(appointment, AppointmentResponse.class)).
                collect(Collectors.toList());
        if (appointments.isEmpty()) {
            return ResultHelper.notFound(appointmentResponse);
        } else {
            return ResultHelper.success(appointmentResponse);
        }
    }


}
