package com.java.veterinary.business.abstracts;

import com.java.veterinary.entity.Doctor;
import org.springframework.data.domain.Page;

public interface IDoctorService {
    Doctor get(long id);
    Doctor save(Doctor doctor);
    Doctor update(Doctor doctor);
    Page<Doctor> cursor(int page, int pageSize);
    String delete(long id);
}
