package com.rodrigosousa.poi.controllers;

import com.rodrigosousa.poi.controllers.dto.CreatePointOfInterest;
import com.rodrigosousa.poi.entities.PointOfInterest;
import com.rodrigosousa.poi.repositories.PointOfInterestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointOfInteresController {

    private final PointOfInterestRepository repository;

    public PointOfInteresController(PointOfInterestRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/points-of-interest")
    public ResponseEntity<?> createPointOfInterest(@RequestBody CreatePointOfInterest body) {

        repository.save(new PointOfInterest(body.name(), body.x(), body.y()));

        return ResponseEntity.ok().build();
    }
}
