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
@RequestMapping(path = "/Login")
public class LoginController {
	
private final UserService userService;
	
	@Autowired
	public LoginController(UserService userService) {
	this.userService= userService;
	}
	
	@PostMapping
	public String updateUser( 
			@RequestParam(required = true) String name,
			@RequestParam(required = true) String password) {
		boolean Authenticated = userService.Login(name,password);
		if(Authenticated) {
			return "Welcome User";
		}
		else {
			return "Invalid Credentials";
		}
	
	}
}
