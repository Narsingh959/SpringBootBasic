package com.fisrt.test.localRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UsersList {

	List<Users> userList = new ArrayList<Users>();
	

	public boolean createUser(Users users) {
		boolean isAdded = userList.add(users);
		return isAdded;
	}
	public List<Users> getAllUsers() {
		return userList;

	}
	public Users getUserById(Integer id) {

		Users users = userList.stream().filter(e -> e.getUserId().equals(id)).findFirst().get();

		return users;
	}
	public boolean removeUser(Integer id) {
		
		Users users = userList.stream().filter(e -> e.getUserId().equals(id)).findFirst().get();
		boolean recordDeleted = userList.remove(users);
		
		return recordDeleted;
	}
	
	
}

