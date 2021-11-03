package SimpleLogincom.example.SimpleLogin.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import SimpleLogincom.example.SimpleLogin.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT s FROM User s WHERE s.userName = ?1")
	Optional<User> findUserByName(String name);
}
