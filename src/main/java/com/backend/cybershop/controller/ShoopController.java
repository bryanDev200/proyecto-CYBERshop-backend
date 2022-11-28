package com.backend.cybershop.controller;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.cybershop.dto.ShoopUserDTO;
import com.backend.cybershop.service.interfaces.IShoopService;

@RestController
@RequestMapping("/api/shoop")
@CrossOrigin(origins = "*")
public class ShoopController {
	@Autowired
	private IShoopService shoopService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllShoops(){
		HashMap<String, Object> response = new HashMap<>();
		List<ShoopUserDTO> data = shoopService.getShoops();
		if(data.size() > 0) {
			response.put("data", data);
		}else {
			response.put("message", "No existen tiendas registradas");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.cybershop.entity.Shoop;
import com.backend.cybershop.service.interfaces.ShoopService;

@RestController
@RequestMapping("/url/tiendas")
public class ShoopController {

	@Autowired
	private ShoopService shoopservice;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Shoop>> listaShoop(){
		List<Shoop> lista = shoopservice.listarTiendas();
		return ResponseEntity.ok(lista);
	}
	
}
>>>>>>> cf0e39efa6ed7b080680e5d5d51826abb6d5d794
