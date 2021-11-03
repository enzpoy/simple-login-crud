package SimpleLogincom.example.SimpleLogin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SimpleLogincom.example.SimpleLogin.Model.User;
import SimpleLogincom.example.SimpleLogin.Service.UserService;

@RestController
@RequestMapping(path = "/User")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
	this.userService= userService;
	}
	
	@GetMapping
	public List<User> getUser() { 
		return userService.getUsers();
	}
	
	@PostMapping
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@DeleteMapping(path = "{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteUser(userId);
	}
	
	@PutMapping(path ="{userId}")
	public void updateUser(
			@PathVariable("userId") Long userId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String password) {
		userService.updateUser(userId,name,password);
		
	}
	
}
