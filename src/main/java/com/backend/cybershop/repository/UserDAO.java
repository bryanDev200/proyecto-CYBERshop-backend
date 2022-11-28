package com.backend.cybershop.repository;
	
<<<<<<< HEAD
	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
=======
	import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
>>>>>>> cf0e39efa6ed7b080680e5d5d51826abb6d5d794
	import org.springframework.stereotype.Repository;

	import com.backend.cybershop.entity.User;

@Repository
<<<<<<< HEAD
public interface UserDAO extends JpaRepository<User, Long> {
	@Query("select u from User u where (u.userNames like ?1) and (?2 is -1 or u.userRol.rolId = ?2) and (?3 is -1 or u.shoop.shoopId = ?3)")
	public List<User> getAllUserFilters(String name, int role, int shoop);
}
=======
public interface UserDAO extends JpaRepository<User, Long> {}
>>>>>>> cf0e39efa6ed7b080680e5d5d51826abb6d5d794
