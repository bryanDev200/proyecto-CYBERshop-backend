package com.backend.cybershop.service.interfaces;

import com.backend.cybershop.dto.ProductDTO;
import com.backend.cybershop.entity.Product;

public interface IProductService {
	public ProductDTO saveProduct();
	public Product getProductById(long id);
}