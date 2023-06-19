package com.cruds.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cruds.restfulwebservices.bean.HelloWorldBean;

@RestController
public class HelloWorldController {

//	@GetMapping("/hello-world")
	@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
	public String HelloWorld()
	{
		return "Hello World"; //prints Hello World
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
				  //Prints in JSON format 	
		return new HelloWorldBean("Hello World");
	}
	
	// /users/{id}/todos/{id}  ==>/users/2/todos/12
	// /hello-world/path-variable/Subba
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
	{
		return new HelloWorldBean("Hello World, "+ name);		  	
	//	return new HelloWorldBean(String.format("Hello World , %s", name));
	}
}
