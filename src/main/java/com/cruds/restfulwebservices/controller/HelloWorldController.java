package com.cruds.restfulwebservices.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cruds.restfulwebservices.bean.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	//for i18n
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

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
	
	//for i18n
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale );
		
		//return "Hello World "; 
		
//		- Example: `en` - English (Good Morning)
//		- Example: `nl` - Dutch (Goedemorgen)
//		- Example: `fr` - French (Bonjour)
//		- Example: `de` - Deutsch (Guten Morgen)

	}
}
