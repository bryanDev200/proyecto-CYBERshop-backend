package com.backend.cybershop.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
import org.springframework.web.multipart.MultipartFile;

import com.backend.cybershop.dto.RegisterUserDTO;
import com.backend.cybershop.dto.RegisterUserResponseDTO;
import com.backend.cybershop.dto.UserListItemDTO;
import com.backend.cybershop.entity.ProductImage;
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
		
		User user = userService.getUserById(id);
		String messageDeleted= userService.deleteUser(id);
		
		String nameLastImage = user.getUserImage();
		
		if(nameLastImage != null && nameLastImage.length() > 0) {
			Path lastFilePath = Paths.get("uploads").resolve(nameLastImage).toAbsolutePath();
			File fileLastImage = lastFilePath.toFile();
			if(fileLastImage.exists() && fileLastImage.canRead()) {
				fileLastImage.delete();
			}
		}
		
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
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadUserImage(@RequestParam("file") MultipartFile file,
												@RequestParam("id") int id){
		HashMap<String, Object> response = new HashMap<>();

		User user = userService.getUserById(id);
		
		if(!file.isEmpty()) {
			String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ", "");
			Path filePath = Paths.get("uploads").resolve(fileName).toAbsolutePath();
			
			try {
				Files.copy(file.getInputStream(), filePath);
			} catch (IOException e) {
				response.put("message", "Error al cargar la imagen");
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String nameLastImage = user.getUserImage();
			
			if(nameLastImage != null && nameLastImage.length() > 0) {
				Path lastFilePath = Paths.get("uploads").resolve(nameLastImage).toAbsolutePath();
				File fileLastImage = lastFilePath.toFile();
				if(fileLastImage.exists() && fileLastImage.canRead()) {
					fileLastImage.delete();
				}
			}
			
			user.setUserImage(fileName);
			
			RegisterUserDTO dto = new RegisterUserDTO(user.getDniNumber(), user.getPassword(), user.getUserImage(),
					user.getUserLastName(), user.getUserNames(), user.getUserNickName(), user.getUserPhone(),
					(int)user.getDocument().getDocumentId(), (int)user.getShoop().getShoopId(), 
					(int)user.getUserRol().getRolId(), user.isEnabled());

			userService.updateUser(dto, id);
			
			response.put("message", "imagen cargada correctamente");
		}
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}