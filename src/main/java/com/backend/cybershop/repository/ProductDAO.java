package com.backend.cybershop.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.backend.cybershop.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long>{}