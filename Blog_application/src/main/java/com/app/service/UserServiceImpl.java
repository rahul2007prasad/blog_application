package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.UserDto;
import com.app.exceptions.ResourceNotFoundException;
import com.app.pojos.User;
import com.app.repository.UserRepo;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.dtoToUser(userDto);
		
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
		
		
		
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow( () -> new ResourceNotFoundException("User","User ID",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassowrd());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepo.save(user);
		
	    UserDto userDto1 =	this.userToDto(updatedUser);
	    return userDto1;
		
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User ID", userId));
		return this.userToDto(user);
		
	}

	@Override
	public List<UserDto> getAllUsers() {
		
	List<User> users=	this.userRepo.findAll();
		List<UserDto> userDtos=users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		
		return userDtos;
		
		
	}

	@Override
	public void deleteUser(Integer userId) {
		
		User user =this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
		this.userRepo.delete(user);
		
		
	}

	
	private User dtoToUser(UserDto userDto) {
		User user = new User();
		
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassowrd());
		user.setAbout(userDto.getAbout());
		return user;
	}
	
	public UserDto userToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassowrd(user.getPassword());
		userDto.setAbout(user.getAbout());
		return userDto;
	}
	
	
	
}
