package SimpleLogincom.example.SimpleLogin;

import java.util.List;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import SimpleLogincom.example.SimpleLogin.Model.User;

@SpringBootApplication
@RestController
public class SimpleLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleLoginApplication.class, args);

	}
}
