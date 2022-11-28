package com.backend.cybershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.cybershop.entity.Product;
import com.backend.cybershop.entity.ProductImage;
import com.backend.cybershop.repository.ProductImagesDAO;
import com.backend.cybershop.service.interfaces.IProductImageService;

@Service
public class ProductImageService implements IProductImageService {
	@Autowired
	private ProductImagesDAO repo;
	
	@Override
	public ProductImage saveImage(String url, int id) {
		ProductImage pi = new ProductImage();
		
		pi.setImageUrl(url);
		pi.setProduct(new Product(id));
		
		return repo.save(pi);
	}

	@Override
	public ProductImage getImageByProductId(long productId) {
		return repo.getImageByProductId(productId);
	}

	@Override
	public void deleteImage(long id) {
		repo.deleteById(id);
	}
}