package com.rodrigosousa.poi.controllers;

import com.rodrigosousa.poi.controllers.dto.CreatePointOfInterest;
import com.rodrigosousa.poi.entities.PointOfInterest;
import com.rodrigosousa.poi.repositories.PointOfInterestRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PointOfInteresController {

    private final PointOfInterestRepository repository;

    public PointOfInteresController(PointOfInterestRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/points-of-interest")
    public ResponseEntity<Void> createPointOfInterest(@RequestBody CreatePointOfInterest body) {

        repository.save(new PointOfInterest(body.name(), body.x(), body.y()));

        return ResponseEntity.ok().build();
    }

    @GetMapping("/points-of-interest")
    public ResponseEntity<Page<PointOfInterest>> listPointOfInterest(@RequestParam(name="page", defaultValue = "0") Integer page,
                                                                     @RequestParam(name="pageSize", defaultValue = "10") Integer pageSize) {

        var body = repository.findAll(PageRequest.of(page, pageSize));

        return ResponseEntity.ok(body);
    }

    @GetMapping("/nearby-points-of-interest")
    public ResponseEntity<List<PointOfInterest>> nearbyPointOfInterest(@RequestParam(name="x") Long x,
                                                                       @RequestParam(name="y") Long y,
                                                                       @RequestParam(name="dmax") Long dmax) {

        var xMin = x - dmax;
        var xMax = x + dmax;
        var yMin = y - dmax;
        var yMax = y + dmax;

        var body = repository.findNearMe(xMin, xMax, yMin, yMax);

        return ResponseEntity.ok(body);
    }
}
