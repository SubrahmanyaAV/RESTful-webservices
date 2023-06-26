package com.cruds.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cruds.restfulwebservices.bean.User;
import com.cruds.restfulwebservices.exception.UserNotFoundException;
import com.cruds.restfulwebservices.service.UserDAOService;

import jakarta.validation.Valid;

@RestController
public class UserController {

//	@Autowired
	private UserDAOService service;

//autowire or add a UserDAOService constructor
	public UserController(UserDAOService service) {
		this.service = service;
	}

	// GET/users
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return service.getAll();
	}

	// GET/users/1
	@GetMapping("/users/{Id}")
	public User findSpecificUser(@PathVariable Integer Id) {
		
		User user = service.findById(Id);
		if(user == null)
			throw new UserNotFoundException("id: " + Id);
		return user;
	}

	// POST/users
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
						
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()//path of the current request
				.path("/{Id}") //appending a variable
				.buildAndExpand(savedUser.getId()).toUri(); //and replacing with a value 
		return ResponseEntity.created(location).build();
	} //ResponseEntity - extension of HttpEntity that adds HttpStatusCode.

	@DeleteMapping("/users/{Id}")
	public void deleteByUserId(@PathVariable int Id)
	{
		service.deleteById(Id);
	}
}
