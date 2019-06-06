package com.eloudghiri.shops.services;

import com.eloudghiri.shops.dtos.UserDTO;
import com.eloudghiri.shops.dtos.mapper.UserMapper;
import com.eloudghiri.shops.entities.User;
import com.eloudghiri.shops.helper.MD5Haching;
import com.eloudghiri.shops.helper.PrepareHelper;
import com.eloudghiri.shops.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;
    
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public Optional<User> findUserById(Long id){
        return this.userRepository.findById(id);
    }

    @Override
    public UserDTO authtication(String email, String password) {
        return userMapper.toDto(this.userRepository.getUserByEmailPassword(email, MD5Haching.hachingString(password)));
    }

    @Override
	public User registry(UserDTO userDTO) {
		User user = userMapper.toEntity(userDTO);
		user.setToken(MD5Haching.hachingString(user.getEmail().concat(user.getPassword())));
		return this.userRepository.save(user);
	}
    
    @Override
	public boolean validateLoggedUser(Long userId, String token) {
		Optional<User> user = this.findUserById(userId);
		if (user.isPresent()) {
			return PrepareHelper.validateToken(user.get(), token);
		} else {
			return false;
		}
	}
}
