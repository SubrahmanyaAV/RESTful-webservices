package com.cruds.restfulwebservices.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.cruds.restfulwebservices.bean.User;

@Component
public class UserDAOService {

	private static List<User> users = new ArrayList<>();
	
	private static int objCount = 0;
	
	static {
		users.add(new User(++objCount, "Subbu", LocalDate.now().minusYears(30)));
		users.add(new User(++objCount, "Raghu", LocalDate.now().minusYears(25)));
		users.add(new User(++objCount, "Arjuna", LocalDate.now().minusYears(20)));
	}
	
	private static int userCount = 4;
	/*
	 * static { users.add(new User(1, "Subbu", LocalDate.now().minusYears(30)));
	 * users.add(new User(2, "Raghu", LocalDate.now().minusYears(25)));
	 * users.add(new User(3, "Arjuna", LocalDate.now().minusYears(20))); }
	 */
	
	public List<User> getAll()
	{
		return users;
	}
	
	public User findById(int Id)
	{
		//functional programming  				(-> lambda function)
		Predicate<? super User> predicate = user -> user.getId().equals(Id);
//		return users.stream().filter(predicate).findFirst().get();
		return users.stream().filter(predicate).findFirst().orElse(null);
					//value is present itll show or else i'll get a white label error									
		/*
		  taking a list converting it to a stream and filtering
		  based on a predicate
		 */	
	}
	
	public void deleteById(int Id)
	{
		Predicate<? super User> predicate = user -> user.getId().equals(Id);
		users.removeIf(predicate );
	}
	
	public User save(User user)
	{
		//user.setId(++userCount);
		user.setId(++objCount);
		users.add(user);
		return user;
	}
}
