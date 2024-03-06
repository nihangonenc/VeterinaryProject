package com.java.veterinary.business.concretes;

import com.java.veterinary.business.abstracts.ICustomerService;
import com.java.veterinary.core.exception.NotFoundException;
import com.java.veterinary.core.utilies.Msg;
import com.java.veterinary.dao.CustomerRepo;
import com.java.veterinary.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerManager implements ICustomerService {
    private final CustomerRepo customerRepo;

    public CustomerManager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer get(long id) {
        return this.customerRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Customer save(Customer customer) { //DEĞERLENDİRME FORMU 10
        Optional<Customer> isCustomerExist = customerRepo.findByMail(customer.getMail());
        if (isCustomerExist.isEmpty()) {
            return this.customerRepo.save(customer);
        }
        throw new RuntimeException("Bu Müşteri Sistemde Kayıtlı");
    }

    @Override
    public Customer update(Customer customer) {
        Optional<Customer> isCustomerExist = customerRepo.findById(customer.getId());
        if (isCustomerExist.isEmpty()){
            throw new RuntimeException("Müşteri Sistemde Bulunamadı");
        }
        this.get(customer.getId());
        return this.customerRepo.save(customer);
    }

    @Override
    public Page<Customer> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.customerRepo.findAll(pageable);
    }

    @Override
    public String delete(long id) {
        Optional<Customer> isCustomerExist = customerRepo.findById(id);
        if (isCustomerExist.isEmpty()){
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        else {
            customerRepo.delete(isCustomerExist.get());
            return Msg.OK;
        }
    }

    @Override
    public List<Customer> getCustomerByName(String name) {  //DEĞERLENDİRME FORMU 11
        return customerRepo.findByNameIgnoreCase(name);
    }
}
