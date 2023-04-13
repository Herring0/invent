package com.herring.invent.controllers.api;

import com.herring.invent.repository.CountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/countries")
public class CountriesController {

    @Autowired
    private CountriesRepository countriesRepository;

    @GetMapping("/list")
    private ResponseEntity<?> countriesList() {
        return ResponseEntity.ok(countriesRepository.findAll());
    }

    @GetMapping("{id}")
    private ResponseEntity<?> countryById(@PathVariable int id) {
        return ResponseEntity.ok(countriesRepository.findById(id));
    }
}
