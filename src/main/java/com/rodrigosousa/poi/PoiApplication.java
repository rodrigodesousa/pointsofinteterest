package com.rodrigosousa.poi;

import com.rodrigosousa.poi.entities.PointOfInterest;
import com.rodrigosousa.poi.repositories.PointOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PoiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PoiApplication.class, args);
	}

    @Autowired
    private PointOfInterestRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new PointOfInterest("Lanchonete", 27L, 12L));
        repository.save(new PointOfInterest("Posto", 31L, 18L));
        repository.save(new PointOfInterest("Joalheria", 15L, 12L));
        repository.save(new PointOfInterest("Floricultura", 19L, 21L));
        repository.save(new PointOfInterest("Pub", 12L, 8L));
        repository.save(new PointOfInterest("Supermercado", 23L, 6L));
        repository.save(new PointOfInterest("Churrascaria", 28L, 2L));
    }
}
