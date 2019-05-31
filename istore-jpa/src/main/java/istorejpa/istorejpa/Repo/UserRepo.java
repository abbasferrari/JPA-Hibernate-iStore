package istorejpa.istorejpa.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import istorejpa.istorejpa.Models.User;



public interface UserRepo extends CrudRepository<User,Long>{
	User findById(String id);
	User findByEmail(String email);
	List<User> findByName(String name);
	List<User> findAll();
}
