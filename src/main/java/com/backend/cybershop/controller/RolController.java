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
	
	import com.backend.cybershop.dto.RolUserDTO;
	import com.backend.cybershop.service.interfaces.IRolService;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RolController {
	@Autowired
	private IRolService rolService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllRoles(){
		HashMap<String, Object> response = new HashMap<>();
		List<RolUserDTO> data = rolService.getRoles();
		if(data.size() > 0) {
			response.put("data", data);
		}else {
			response.put("message", "No existen roles registrados");
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
>>>>>>> cf0e39efa6ed7b080680e5d5d51826abb6d5d794
