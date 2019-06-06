package com.eloudghiri.shops.services;


import com.eloudghiri.shops.dtos.UserDTO;
import com.eloudghiri.shops.entities.User;

import java.util.Optional;

public interface IUserService {

    Optional<User> findUserById(Long id);

    UserDTO authtication(String email, String password);

    User registry(UserDTO userDTO);

	boolean validateLoggedUser(Long userId, String token);
}
