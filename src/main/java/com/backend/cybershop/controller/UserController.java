package com.backend.cybershop.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody RegisterUserDTO bean){
		HashMap<String, Object> response = new HashMap<>();
		bean.setPassword(passwordEncoder.encode(bean.getPassword()));
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
