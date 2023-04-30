package com.herring.invent.repository;

import com.herring.invent.models.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
}
