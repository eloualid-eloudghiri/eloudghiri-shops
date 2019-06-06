package com.eloudghiri.shops.dtos;


import com.eloudghiri.shops.entities.Coordinate;

public class UserDTO {

    private Long id;

    private String lastName;

    private String firstName;

    private String email;

    private String telephone;

    private String password;
    
    private String token; 

    private Coordinate coordinate;

    public UserDTO(Long id, String lastName, String firstName, String email, String telephone, String password, Coordinate coordinate) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.coordinate = coordinate;
    }

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public UserDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public UserDTO setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public UserDTO setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
        return this;
    }

	public String getToken() {
		return token;
	}

	public UserDTO setToken(String token) {
		this.token = token;
		return this;
	}
}
