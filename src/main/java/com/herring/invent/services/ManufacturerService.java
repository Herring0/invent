package com.herring.invent.services;

import com.herring.invent.models.Manufacturer;
import com.herring.invent.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> getAllManufacturer() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer getManufacturerById(int id) {
        return manufacturerRepository.findById(id).orElse(null);
    }
}
