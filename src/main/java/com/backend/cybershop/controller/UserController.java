package com.backend.cybershop.controller;

import java.util.HashMap;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Map;
>>>>>>> cf0e39efa6ed7b080680e5d5d51826abb6d5d794

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.cybershop.dto.RegisterUserDTO;
import com.backend.cybershop.dto.RegisterUserResponseDTO;
import com.backend.cybershop.dto.UserListItemDTO;
import com.backend.cybershop.entity.User;
import com.backend.cybershop.service.interfaces.IUsuarioService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private IUsuarioService userService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody RegisterUserDTO bean){
		HashMap<String, Object> response = new HashMap<>();
		RegisterUserResponseDTO userSaved= userService.saveUser(bean);
		if(userSaved != null) {
			response.put("message", "Usuario registrado correctamente");
		}else {
			response.put("message", "error al registrar usuario");
		}
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody RegisterUserDTO bean){
		HashMap<String, Object> response = new HashMap<>();
		String messageUpdated = userService.updateUser(bean, id);
		
		response.put("message", messageUpdated);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id){
		HashMap<String, Object> response = new HashMap<>();
		String messageDeleted= userService.deleteUser(id);
		
		response.put("message", messageDeleted);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id){
		HashMap<String, Object> response = new HashMap<>();
		User user = userService.getUserById(id);
		
		if(user != null){
			response.put("user", user);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {
			response.put("message", "Usuario no encontrado");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findUsers")
	public ResponseEntity<?> listaAlumnosPorFiltros(@RequestParam(value = "names", required = false, defaultValue = "") String names,
											   @RequestParam(value = "rolId", required = false, defaultValue = "-1") int rolId,
											   @RequestParam(value = "shoopId", required = false, defaultValue = "-1") int shoopId){
		HashMap<String, Object> response = new HashMap<>();
		
		List<UserListItemDTO> data = userService.getAllUsers("%" + names + "%", rolId, shoopId);
		
		response.put("data", data);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
=======
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
>>>>>>> cf0e39efa6ed7b080680e5d5d51826abb6d5d794
