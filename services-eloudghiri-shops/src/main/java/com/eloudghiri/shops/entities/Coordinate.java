package com.eloudghiri.shops.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Coordinates")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Position_axes")
    private Double positionX;

    @Column(name = "Position_absis")
    private Double positionY;

    public Coordinate(Double positionX, Double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Coordinate() {
    }

    public Long getId() {
        return id;
    }

    public Coordinate setId(Long id) {
        this.id = id;
        return this;
    }

    public double getPositionX() {
        return positionX;
    }

    public Coordinate setPositionX(Double positionX) {
        this.positionX = positionX;
        return this;
    }

    public double getPositionY() {
        return positionY;
    }

    public Coordinate setPositionY(Double positionY) {
        this.positionY = positionY;
        return this;
    }
}
