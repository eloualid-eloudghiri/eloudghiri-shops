package com.eloudghiri.shops.dtos;


import com.eloudghiri.shops.entities.Coordinate;

public class ShopDTO {

	private Long id;

	private String name;

	private String adresse;

	private String uri;

	private Coordinate coordinate;

	public Long getId() {
		return id;
	}

	public ShopDTO setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public ShopDTO setName(String name) {
		this.name = name;
		return this;
	}

	public String getAdresse() {
		return adresse;
	}

	public ShopDTO setAdresse(String adresse) {
		this.adresse = adresse;
		return this;
	}

	public String getUri() {
		return uri;
	}

	public ShopDTO setUri(String uri) {
		this.uri = uri;
		return this;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public ShopDTO setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
		return this;
	}

}
