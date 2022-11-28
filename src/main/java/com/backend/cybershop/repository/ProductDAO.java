package com.backend.cybershop.repository;

	import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

	import com.backend.cybershop.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long>{
	@Query("select p from Product p where (p.productName like ?1) and (?2 is -1 or u.subCategory.subCategory = ?2)")
	public List<Product> getAllProducts(String name, long categoryId);
}