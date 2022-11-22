package com.backend.cybershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.cybershop.entity.Rol;
import com.backend.cybershop.service.interfaces.RolService;

@RestController
@RequestMapping("/url/roles")
public class RolController {

	@Autowired
	private RolService rolservice;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Rol>> listaRol(){
		List<Rol> lista = rolservice.listarRoles();
		return ResponseEntity.ok(lista);
	}
}
