package com.fisrt.test.controller;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.UploadContext;
import org.omg.PortableServer.Servant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fisrt.test.entity.UserDetails;
import com.fisrt.test.entity.UserResponse;
import com.fisrt.test.services.UserServices;

@RestController
public class UserController {

	@Autowired
	private UserServices userServiceImple;

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String Hello() {
		return "hello";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UserResponse> createUser(@RequestBody UserDetails userDetails) {

		UserDetails userDetails2 = this.userServiceImple.Registration(userDetails);
		int i = userDetails2.getUserId();
		if (i >= 0)

			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity getAll() {

		List users = this.userServiceImple.getAllUsers();
		return ResponseEntity.ok(users);

	}

	@GetMapping(value = "/getUser/{id}")
	public ResponseEntity<UserDetails> getUserById(@PathVariable("id") Integer id) {

		Optional<UserDetails> resultuserdeatils = this.userServiceImple.getUserById(id);

		boolean anyRecord = resultuserdeatils.isPresent();

		if (anyRecord)
			return ResponseEntity.of(resultuserdeatils);
		else
			return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/deletUser/{id}")
	public ResponseEntity deletUser(@PathVariable("id") Integer id) {

		this.userServiceImple.deleteUser(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();

	}
	
	@PutMapping("/UpdateUser/{id}")
	public ResponseEntity<UserDetails> updateUser(@RequestBody UserDetails userDetails,@PathVariable("id") Integer id) {
		
		UserDetails resultObject = this.userServiceImple.updateUser(userDetails, id);
		if(resultObject.getUserId()!=null)
		
		return ResponseEntity.of(Optional.of(resultObject)).status(HttpStatus.NO_CONTENT).build();
		else
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
			
	}
	       @PostMapping(value = "/uploadFile")
          public ResponseEntity<String> upload(@RequestParam MultipartFile multipartFile){
        	  
        	long filesize=  multipartFile.getSize();
        	if(filesize!=0) {
        	  this.userServiceImple.uploadFile(multipartFile);
        	  return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(multipartFile.getOriginalFilename()).toUriString());
        	}
               return   ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            		   }
}
