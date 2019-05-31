package istorejpa.istorejpa.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import istorejpa.istorejpa.Models.Item;

public interface ItemRepo extends CrudRepository<Item,Long>{
	List<Item> findAll();
	List<Item> findBysellerId(String sellerId);
	Item findById(Integer id);
	List<Item> findByCategory(String value);
	List<Item> findByName(String name);
}
