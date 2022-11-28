package com.backend.cybershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.cybershop.dto.ProductDTO;
import com.backend.cybershop.entity.Product;
import com.backend.cybershop.repository.ProductDAO;
import com.backend.cybershop.service.interfaces.IProductService;

@Service
public class ProductService implements IProductService {
	@Autowired
	private ProductDAO repo;
	
	@Override
	public ProductDTO saveProduct() {
		return null;
	}

	@Override
	public Product getProductById(long id) {
		try {
			Product productFound = repo.findById(id).get();
			return productFound;
		}catch(Exception e) {
			return null;
		}
	}	
}