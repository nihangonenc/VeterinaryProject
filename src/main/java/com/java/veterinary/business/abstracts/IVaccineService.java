package com.java.veterinary.business.abstracts;



import com.java.veterinary.core.result.ResultData;
import com.java.veterinary.dto.response.VaccineResponse;
import com.java.veterinary.entity.Vaccine;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface IVaccineService {
    Vaccine get(long id);
    Vaccine save(Vaccine vaccine);
    Vaccine update(Vaccine vaccine);
    Page<Vaccine> cursor(int page, int pageSize);
    String delete(long id);
    ResultData<List<VaccineResponse>> getByAnimalId(Long id);
    ResultData<List<VaccineResponse>> getByProtectionDateBetween(LocalDate startDate, LocalDate finishDate);
}
