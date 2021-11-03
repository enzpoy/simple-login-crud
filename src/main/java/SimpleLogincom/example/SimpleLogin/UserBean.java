package SimpleLogincom.example.SimpleLogin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import SimpleLogincom.example.SimpleLogin.Model.User;
import SimpleLogincom.example.SimpleLogin.Repository.UserRepository;

@Configuration
public class UserBean {
	
	@Bean
	CommandLineRunner commandLineRunner(UserRepository repository) {
		return args -> {
			User admin = new User("Ron","Ron123");
			//repository.save(admin);
		};
	}
}
