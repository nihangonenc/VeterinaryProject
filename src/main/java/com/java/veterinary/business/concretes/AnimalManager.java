package com.java.veterinary.business.concretes;

import com.java.veterinary.business.abstracts.IAnimalService;
import com.java.veterinary.core.exception.NotFoundException;
import com.java.veterinary.core.utilies.Msg;
import com.java.veterinary.dao.AnimalRepo;
import com.java.veterinary.entity.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalManager implements IAnimalService {
    private final AnimalRepo animalRepo;

    public AnimalManager(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    @Override
    public Animal get(long id) {
        return this.animalRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Animal save(Animal animal) {  //DEĞERLENDİRME FORMU 12
        Optional<Animal> isAnimalExist = animalRepo.findByNameAndSpeciesAndDateOfBirth(animal.getName(),animal.getSpecies(),animal.getDateOfBirth());
        if (isAnimalExist.isEmpty()) {
            return this.animalRepo.save(animal);
        }
        throw new RuntimeException("Bu Hayvan Sistemde Kayıtlı");
    }

    @Override
    public Animal update(Animal animal) {
        Optional<Animal> isAnimalExist = animalRepo.findById(animal.getId());
        if (isAnimalExist.isEmpty()){
            throw new RuntimeException("Hayvan Sistemde Bulunamadı");
        }
        this.get(animal.getId());
        return this.animalRepo.save(animal);
    }

    @Override
    public Page<Animal> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.animalRepo.findAll(pageable);
    }

    @Override
    public String delete(long id) {
        Optional<Animal> isAnimalExist = animalRepo.findById(id);
        if (isAnimalExist.isEmpty()){
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        else {
            animalRepo.delete(isAnimalExist.get());
            return Msg.OK;
        }
    }
    @Override
    public List<Animal> getAnimalByName(String name) { //hayvanları isme göre filtreleme:  DEĞERLENDİRME FORMU 13
        return animalRepo.findByNameIgnoreCase(name);
    }
    @Override
    public List<Animal> getAnimalByCustomer(Long id) { //hayvanları sahiplerine göre filtreleme  DEĞERLENDİRME FORMU 14
        return animalRepo.findByCustomerId(id);
    }
}
