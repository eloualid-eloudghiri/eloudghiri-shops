package com.eloudghiri.shops.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Shops")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "name_shop")
    private String name;

    @NotNull
    @Column(name  = "adresse")
    private String adresse;

    @NotNull
    @Column(name  = "uri")
    private String uri;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "coordinate_id")
    private Coordinate coordinate;

    public Shop(@NotNull String name, @NotNull String adresse, @NotNull String uri, @NotNull boolean liked, @NotNull Coordinate coordinate) {
        this.name = name;
        this.adresse = adresse;
        this.uri = uri;
        this.coordinate = coordinate;
    }

    public Shop() {
    }

    public Long getId() {
        return id;
    }

    public Shop setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Shop setName(String name) {
        this.name = name;
        return this;
    }

    public String getAdresse() {
        return adresse;
    }

    public Shop setAdresse(String adresse) {
        this.adresse = adresse;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public Shop setUri(String uri) {
        this.uri = uri;
        return this;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Shop setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
        return this;
    }

}
