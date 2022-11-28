package com.backend.cybershop.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.cybershop.dto.ProductListItemDTO;
import com.backend.cybershop.entity.Product;
import com.backend.cybershop.service.interfaces.IProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private IProductService productService;
	
	@GetMapping("get/{id}")
	public ResponseEntity<?> getProduct(@PathVariable int id){
		HashMap<String, Object> response = new HashMap<>();
		
		Product product = productService.getProductById(id);
		
		if(product != null) {
			response.put("data", product);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {
			response.put("message", "Producto no encontrado");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findProducts")
	public ResponseEntity<?> getAllProductsFiler(@RequestParam(value = "productName", required = false, defaultValue = "") String productName,
			   @RequestParam(value = "subCategoryId", required = false, defaultValue = "-1") int subCategoryId){
		HashMap<String, Object> response = new HashMap<>();
		
		List<ProductListItemDTO> data = productService.getAllProducts("%" + productName + "%", subCategoryId);
		
		response.put("data", data);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}