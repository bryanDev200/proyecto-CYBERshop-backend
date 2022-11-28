package com.backend.cybershop.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.cybershop.dto.OrderRegisterDTO;
import com.backend.cybershop.entity.Order;
import com.backend.cybershop.service.interfaces.IOrderService;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveOrder(@RequestBody OrderRegisterDTO bean){
		HashMap<String, Object> response = new HashMap<>();
		Order order = orderService.saveOrder(bean);
		
		if(order != null) {
			response.put("order", order);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}else {
			response.put("message", "Error al registrar pedido");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}