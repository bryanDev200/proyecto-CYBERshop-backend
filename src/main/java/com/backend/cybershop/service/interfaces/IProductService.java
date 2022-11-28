package com.backend.cybershop.service.interfaces;

import java.util.List;

import com.backend.cybershop.dto.ProductDTO;
import com.backend.cybershop.dto.ProductListItemDTO;
import com.backend.cybershop.entity.Product;

public interface IProductService {
	public ProductDTO saveProduct();
	public Product getProductById(long id);
	public List<ProductListItemDTO> getAllProducts(String names, long id);
}