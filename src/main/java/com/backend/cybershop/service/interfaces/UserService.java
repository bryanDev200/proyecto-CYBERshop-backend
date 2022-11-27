package com.backend.cybershop.service.interfaces;

import java.util.List;

import com.backend.cybershop.dto.UserDTO;
import com.backend.cybershop.dto.UserRespuestaDTO;
import com.backend.cybershop.entity.User;

public interface UserService {

/*
	public UserDTO crearUser(UserDTO userDTO);
	
	public UserRespuestaDTO obtenerTodosLosUsuarios(int numerodePagina, int medidaDePagina,String ordenarPor,String sortDir);
	
	public UserDTO obtenerUserPorID(long userId);
	
	
	*/
	
	
	public List<User> listarUsuarios();
	
	
	public User registrar(User bean);
	
	public User buscar(Long cod);
}
