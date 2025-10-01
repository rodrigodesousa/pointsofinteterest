package com.rodrigosousa.poi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "points_of_interest")
@Getter
@Setter
@NoArgsConstructor
public class PointOfInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long x;
    private Long y;

    public PointOfInterest(String name, Long x, Long y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
}
