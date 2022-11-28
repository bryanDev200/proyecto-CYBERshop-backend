package com.backend.cybershop.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.security.authentication.AuthenticationManager;
	import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
	import org.springframework.security.core.Authentication;
	import org.springframework.security.core.context.SecurityContextHolder;
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.backend.cybershop.dto.JwtRequest;
	import com.backend.cybershop.dto.JwtResponse;
	import com.backend.cybershop.entity.User;
	import com.backend.cybershop.security.JwtTokenProvider;
	import com.backend.cybershop.service.interfaces.IUsuarioService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private IUsuarioService service;
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> authenticateUser(@RequestBody JwtRequest loginDTO){
		Authentication authentication = authenticationManager
										.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), 
																						      loginDTO.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtTokenProvider.generarToken(authentication);
		User user = service.getUserByUsername(loginDTO.getUsername());
		JwtResponse response = new JwtResponse(token);
		response.setFirstName(user.getUserNames());
		response.setLastName(user.getUserLastName());
		response.setPhone(user.getUserPhone());
		response.setImage(user.getUserImage());
		response.setUsername(user.getUserNickName());
		response.setRol(user.getUserRol());
		response.setId(user.getUserId());
		
		return ResponseEntity.ok(response);
	}
}