package com.java.veterinary.core.config.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig { // proje her başladığında modelmapper nesnesi üretip ioc container içine atması amaçlanır
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}