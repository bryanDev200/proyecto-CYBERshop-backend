package com.backend.cybershop.repository;
	
	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;

	import org.springframework.stereotype.Repository;

	import com.backend.cybershop.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
	@Query("select u from User u where (u.userNames like ?1) and (?2 is -1 or u.userRol.rolId = ?2) and (?3 is -1 or u.shoop.shoopId = ?3)")
	public List<User> getAllUserFilters(String name, int role, int shoop);
}