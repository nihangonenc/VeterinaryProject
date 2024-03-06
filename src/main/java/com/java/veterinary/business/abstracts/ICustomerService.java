package com.java.veterinary.business.abstracts;


import com.java.veterinary.entity.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICustomerService {
    Customer get(long id);
    Customer save(Customer customer);
    Customer update(Customer customer);
    Page<Customer> cursor(int page, int pageSize);
    String delete(long id);
    List<Customer> getCustomerByName (String name);
}
