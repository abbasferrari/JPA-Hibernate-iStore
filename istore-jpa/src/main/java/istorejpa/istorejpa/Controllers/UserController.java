package istorejpa.istorejpa.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import istorejpa.istorejpa.Models.User;
import istorejpa.istorejpa.Repo.UserRepo;


@RestController
@CrossOrigin(origins = "https://istore-angular.herokuapp.com")
public class UserController {

	
@Autowired
UserRepo repo;
	
@GetMapping("/userstest")
public String insertUser() {
	repo.save(new User("abbas@gmail.com","abbas2508","Mohamed Abbas","IND","12345","9597069651"));
	repo.save(new User("abbas12@gmail.com","abbas12508","Mohamed Abbas","IND","12345","9597069651"));
	repo.save(new User("abbas23@gmail.com","abbas22508","Mohamed Abbas","IND","12345","9597069651"));
	repo.save(new User("abbas34@gmail.com","abbas32508","Mohamed Abbas","IND","12345","9597069651"));
	return "created USER NAM";
}

@PostMapping("/signup_user")
public int registerUser(@RequestBody User user) {
	repo.save(user);
	return 200;
}

@PostMapping("/auth_user")
public String checkUser(@RequestBody User user) {
	System.out.println(user.toString());
	if (repo.findByEmail(user.getEmail()).getPassword().equals(user.getPassword())) {
			return user.getEmail();
	}
	return null;
}

@GetMapping("/getUsers")
public List<User> getUsers() {
	return repo.findAll();
}

@RequestMapping("/searchbyemail/{id}")
public User fetchDataById(@PathVariable String id){
	return repo.findById(id);
}

@RequestMapping("/searchbyname/{name}")
public List<User> fetchDataByName(@PathVariable String name) {
	return repo.findByName(name);
}

}
