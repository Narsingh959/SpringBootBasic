package com.fisrt.test.services;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.multipart.MultipartFile;

import com.fisrt.test.Repository.UserRepository;
import com.fisrt.test.entity.UserDetails;
import com.fisrt.test.helpers.FileUploadHelper;
import com.fisrt.test.localRepository.Users;
import com.fisrt.test.localRepository.UsersList;
import com.sun.el.stream.Stream;

@Component
public class UserServiceImple implements UserServices {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FileUploadHelper  fileUploadHelper;

	@Override
	public UserDetails Registration(final UserDetails userDetails) {

		UserDetails resultObjectd = this.userRepository.save(userDetails);
		
		return resultObjectd;
	}
	@Override
	public List<UserDetails> getAllUsers() {
		List<UserDetails> allUser = this.userRepository.findAll();
		return allUser;
	}
	

	@Override
	public Optional<UserDetails> getUserById(final Integer id) {
		
		Optional<UserDetails> resultObject = this.userRepository.findById(id);
		
		Boolean availble = resultObject.isPresent();
		
		if(availble) 		
			return  resultObject;
		else
			return null;
		
	 
	}
	@Override
	public void deleteUser(final Integer id) {
		 this.userRepository.deleteById(id);
	}
	
	@Override
	public UserDetails updateUser(UserDetails userDetails,Integer id ) {
		
		userDetails.setUserId(id);
		
	UserDetails resultObject=	this.userRepository.save(userDetails);
	
	
	return resultObject;
	
		
		
	}
	@Override
	public boolean uploadFile(MultipartFile file) 
	{	
		boolean fileuploaded =this.fileUploadHelper.uplodFile(file);
		
		return fileuploaded;
	}
}

