package com.backend.cybershop.service.interfaces;

import java.util.List;

import com.backend.cybershop.dto.ProductListItemDTO;
import com.backend.cybershop.dto.ProductRegisterDTO;
import com.backend.cybershop.entity.Product;

public interface IProductService {
	public Product saveProduct(ProductRegisterDTO bea);
	public Product getProductById(long id);
	public String updateProduct(ProductRegisterDTO bea, int id);
	public String deleteProduct(int id);
	public List<ProductListItemDTO> getAllProducts(String names, int id);
	public List<Product> listAllProducts();
}