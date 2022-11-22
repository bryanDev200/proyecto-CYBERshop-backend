package com.backend.cybershop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.cybershop.dto.UserDTO;
import com.backend.cybershop.dto.UserRespuestaDTO;
import com.backend.cybershop.entity.User;
import com.backend.cybershop.service.interfaces.UserService;
import com.backend.cybershop.utils.Utils;

@RestController
@RequestMapping("/users")
public class UserController {

	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/lista")
	public List<User> lista(){
		return userservice.listarUsuarios();
	}
	/*
	@GetMapping
	public UserRespuestaDTO listarUsers(@RequestParam(value = "pageNo", defaultValue = Utils.NUMERO_DE_PAGINA_POR_DEFECTO, required = false) int numerodePagina,
			@RequestParam(value = "pageSize", defaultValue = Utils.MEDIDA_DE_PAGINA_POR_DEFECTO, required = false) int medidaDePagina,
			@RequestParam(value = "sortBy",defaultValue = Utils.ORDENAR_POR_DEFECTO,required = false) String ordenarPor,
			@RequestParam(value = "sortDir",defaultValue = Utils.ORDENAR_DIRECCION_POR_DEFECTO,required = false) String sortDir) {
		return userservice.obtenerTodosLosUsuarios(numerodePagina, medidaDePagina, ordenarPor, sortDir);
	}
	
	@PostMapping("/registrauser")
	public ResponseEntity<UserDTO> guardarUser(@RequestBody UserDTO userDTO){
		return new ResponseEntity<>(userservice.crearUser(userDTO),HttpStatus.CREATED);
	}
	*/
	
	
	
}
