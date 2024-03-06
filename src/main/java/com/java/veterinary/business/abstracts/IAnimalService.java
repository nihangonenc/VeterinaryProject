package com.java.veterinary.business.abstracts;

import com.java.veterinary.entity.Animal;

import org.springframework.data.domain.Page;

import java.util.List;

public interface IAnimalService {

    Animal get(long id);
    Animal save(Animal animal);
    Animal update(Animal animal);
    Page<Animal> cursor(int page, int pageSize);
    String delete(long id);
    List<Animal> getAnimalByName(String name);
    List<Animal> getAnimalByCustomer(Long id);
}
