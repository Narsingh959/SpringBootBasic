package com.fisrt.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fisrt.test.services.UserServiceImple;
import com.fisrt.test.services.UserServices;


public class JavaConfig {
	
	
	public UserServices userServices() {
		
	return new UserServiceImple();
		
	}
}
