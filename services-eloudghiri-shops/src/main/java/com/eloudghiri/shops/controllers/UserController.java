package com.eloudghiri.shops.controllers;

import com.eloudghiri.shops.dtos.UserDTO;
import com.eloudghiri.shops.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

	@Autowired
	private IUserService userService;
	
	@PostMapping(path = "/register")
	public ResponseEntity<Void> register(@RequestBody UserDTO userDto) {
		userService.registry(userDto);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@GetMapping(path = "/login")
	public ResponseEntity<UserDTO> login(@RequestParam("email") String email,
			@RequestParam("password") String password) {
//		String token = "";
		UserDTO userDTO = userService.authtication(email, password);
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}
}
