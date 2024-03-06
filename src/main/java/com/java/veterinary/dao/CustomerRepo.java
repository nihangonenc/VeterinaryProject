package com.java.veterinary.dao;

import com.java.veterinary.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findByMail(String mail); //kayıt kontrolünde
    List<Customer> findByNameIgnoreCase (String name); //ismi göre filtreleme
}
