package com.backend.cybershop.controller;

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
