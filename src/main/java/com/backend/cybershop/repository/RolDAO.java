package com.backend.cybershop.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.backend.cybershop.entity.Rol;

@Repository
public interface RolDAO extends JpaRepository<Rol, Long> {}