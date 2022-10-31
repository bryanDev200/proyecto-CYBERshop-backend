package com.backend.cybershop.repository;

	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

	import com.backend.cybershop.entity.Rol;

@Repository
public interface RolDAO extends CrudRepository<Rol, Long> {}