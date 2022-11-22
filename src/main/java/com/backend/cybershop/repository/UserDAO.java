package com.backend.cybershop.repository;
	
	import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

	import com.backend.cybershop.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {}