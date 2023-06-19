package com.cruds.restfulwebservices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cruds.restfulwebservices.bean.User;
import com.cruds.restfulwebservices.service.UserDAOService;

@RestController
public class UserController {
	
//	@Autowired
	private UserDAOService service;
	
//autowire or add a UserDAOService constructor
	public UserController(UserDAOService service) {
		this.service = service;
	}
	
	//GET/users
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return service.getAll();
	}
	
	//GET/users/1
	@GetMapping("/users/{Id}")
	public User findSpecificUser(@PathVariable Integer Id)
	{
		return service.findById(Id);
	}
	
	//POST/users
	@PostMapping("/users")
	public void createUser(@RequestBody User user)
	{
		service.save(user);
	}

	

}
