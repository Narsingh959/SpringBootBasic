package com.fisrt.test.services;


import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.fisrt.test.entity.UserDetails;
import com.fisrt.test.localRepository.Users;

public interface UserServices {
	
	public UserDetails Registration(final UserDetails userDetails);

	public List<UserDetails> getAllUsers();
	
	public Optional<UserDetails> getUserById(final Integer id);
	
	public void deleteUser(final Integer id);
	
	public UserDetails updateUser(UserDetails userDetails,Integer id );
	
	public boolean uploadFile(MultipartFile file );
}
