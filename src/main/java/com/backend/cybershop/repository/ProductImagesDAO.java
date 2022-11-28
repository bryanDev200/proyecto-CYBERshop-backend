package com.backend.cybershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.cybershop.entity.ProductImage;

public interface ProductImagesDAO extends JpaRepository<ProductImage, Long> {
	@Query("select pi from ProductImage pi where pi.product.productId = ?1")
	public ProductImage getImageByProductId(long productId);
}