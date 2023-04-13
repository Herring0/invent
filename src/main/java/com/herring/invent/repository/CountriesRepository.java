package com.herring.invent.repository;

import com.herring.invent.models.Category;
import com.herring.invent.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CountriesRepository extends JpaRepository<Country, Integer> {
}
