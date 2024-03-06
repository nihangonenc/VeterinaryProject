package com.java.veterinary.business.concretes;

import com.java.veterinary.business.abstracts.IVaccineService;
import com.java.veterinary.core.config.modelMapper.IModelMapperService;
import com.java.veterinary.core.exception.NotFoundException;
import com.java.veterinary.core.result.ResultData;
import com.java.veterinary.core.utilies.Msg;
import com.java.veterinary.core.utilies.ResultHelper;
import com.java.veterinary.dao.VaccineRepo;
import com.java.veterinary.dto.response.VaccineResponse;
import com.java.veterinary.entity.Vaccine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VaccineManager implements IVaccineService {
    private final VaccineRepo vaccineRepo;
    private final IModelMapperService modelMapper;

    public VaccineManager(VaccineRepo vaccineRepo, IModelMapperService modelMapper) { //CI
        this.vaccineRepo = vaccineRepo;

        this.modelMapper = modelMapper;
    }
    @Override
    public Vaccine get(long id) {
        return this.vaccineRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Vaccine save(Vaccine vaccine) {  //DEĞERLENDİRME FORMU 21-22
        Optional<Vaccine> ProtectionExist = vaccineRepo.
                findByNameAndCodeAndAnimalIdAndProtectionFinishDateGreaterThanEqual(
                        vaccine.getName(),
                        vaccine.getCode(),
                        vaccine.getAnimal().getId(),
                        vaccine.getProtectionStartDate());
        if (ProtectionExist.isEmpty()) {
            return this.vaccineRepo.save(vaccine);
        }else {
            throw new RuntimeException("Bu Aşının Koruyuculuğu Henüz Bitmemiş");
        }

    }

    @Override
    public Vaccine update(Vaccine vaccine) {
        Optional<Vaccine> isVaccineExist = vaccineRepo.findById(vaccine.getId());
        if (isVaccineExist.isEmpty()){
            throw new RuntimeException("Aşı Sistemde Bulunamadı");
        }else {
            this.get(vaccine.getId());
            return this.vaccineRepo.save(vaccine);
        }

    }

    @Override
    public Page<Vaccine> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.vaccineRepo.findAll(pageable);
    }

    @Override
    public String delete(long id) {
        Optional<Vaccine> isVaccineExist = vaccineRepo.findById(id);
        if (isVaccineExist.isEmpty()){
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        else {
            vaccineRepo.delete(isVaccineExist.get());
            return Msg.OK;
        }

    }

    @Override  //bir hayvana ait aşıları listeleme                                     DEĞERLENDİRME FORMU 24
    public ResultData<List<VaccineResponse>> getByAnimalId(Long id) {
        List<Vaccine> vaccines = this.vaccineRepo.findByAnimalId(id);
        List<VaccineResponse> vaccineResponse = vaccines.stream()
                .map(vaccine -> this.modelMapper.forResponse().map(vaccine, VaccineResponse.class))
                .collect(Collectors.toList());
        if (vaccines.isEmpty()) {
            return ResultHelper.notFound(vaccineResponse);
        }else {
            return ResultHelper.success(vaccineResponse);
        }
    }

    @Override  //                                                                    DEĞERLENDİRME FORMU 23
    public ResultData<List<VaccineResponse>> getByProtectionDateBetween(LocalDate startDate, LocalDate finishDate) {
        List<Vaccine> vaccines = this.vaccineRepo.findByProtectionStartDateBetween(startDate, finishDate);
        List<VaccineResponse> vaccineResponse = vaccines.stream()
                .map(vaccine -> this.modelMapper.forResponse().map(vaccine, VaccineResponse.class))
                .collect(Collectors.toList());
        if (vaccines.isEmpty()) {
            return ResultHelper.notFound(vaccineResponse);
        }else {
            return ResultHelper.success(vaccineResponse);
        }
    }
}
