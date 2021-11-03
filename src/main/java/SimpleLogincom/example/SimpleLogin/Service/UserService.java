package SimpleLogincom.example.SimpleLogin.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SimpleLogincom.example.SimpleLogin.Model.User;
import SimpleLogincom.example.SimpleLogin.Repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getUsers(){
		List<User> userlist = userRepository.findAll();
		return userlist;
	}
	
	
	public Optional<User> getUserbyUsername(User user) {
		Optional<User> userbyuserName = userRepository.findUserByName(user.getUserName());
		if(userbyuserName.isPresent()) {
			return userbyuserName;
		}
		else {
			return null;
		}
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		boolean exists = userRepository.existsById(id);
		if(!exists) {
			throw new IllegalStateException("user with id "+id+" does not exist!");
		}
		else {
			userRepository.deleteById(id);
		}
	}
	
	
	@Transactional
	public void updateUser(Long userId, String name , String password) {
		User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("user with id "+ userId +" does not exist!"));
		user.setUserName(name);
		user.setPassword(password);
				
	}
	
	
	public Boolean Login(String username , String password) {
		Optional<User> userbyuserName = userRepository.findUserByName(username);
		if(userbyuserName.isPresent() && userbyuserName.get().getPassword().equals(password)) {
			
			return true;
		}
		else {
			return false;
		}
	}
	
	
	

}
