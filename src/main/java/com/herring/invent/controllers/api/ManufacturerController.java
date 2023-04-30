package com.herring.invent.controllers.api;

import com.herring.invent.models.Manufacturer;
import com.herring.invent.payload.response.ErrorResponse;
import com.herring.invent.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/list")
    public ResponseEntity<?> manufacturersList() {
        return ResponseEntity.ok(manufacturerService.getAllManufacturer());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> categoryById(@PathVariable("id") int id) {
        Manufacturer manufacturer = manufacturerService.getManufacturerById(id);

        if (manufacturer == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Manufacturer not found"));
        else
            return ResponseEntity.ok(manufacturer);
    }
}
