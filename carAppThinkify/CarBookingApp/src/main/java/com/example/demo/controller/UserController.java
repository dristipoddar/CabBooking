package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;



@RestController
@RequestMapping("api/v1/")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user/create")
	public User add_driver(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/user/get")
	public List<User> getallUsers(){
		return userRepository.findAll();
	}
	
	@PutMapping("/user/updateContact/{name}/{contactnum}")
	public void updateContact(@PathVariable String name,@PathVariable String contactnum) {
		User user = userRepository.findbyName(name);
		
		user.setUser_contact(contactnum);
		
		userRepository.save(user);	
	}
	
	@PutMapping("/user/updateUserlocation/{name}/{lat}/{lng}")
	public void update_userLocation(@PathVariable String name,@PathVariable int lat, @PathVariable int lng) {
		User user = userRepository.findbyName(name);
		
		user.setUser_lat(lat);
		user.setUser_long(lng);
		userRepository.save(user);
		
	}
	
	

	
}
