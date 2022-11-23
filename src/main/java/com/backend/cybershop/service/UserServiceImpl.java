package com.backend.cybershop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import com.backend.cybershop.dto.UserDTO;
import com.backend.cybershop.dto.UserRespuestaDTO;
import com.backend.cybershop.entity.User;
import com.backend.cybershop.repository.UserDAO;
import com.backend.cybershop.service.interfaces.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	private ModelMapper modelMapper;

	@Autowired
	private UserDAO userrepo;

	/*
	@Override
	public UserDTO crearUser(UserDTO userDTO) {
		User user = mapearEntidad(userDTO);
		
		User nuevoUser = userrepo.save(user);
		
		UserDTO userRespuestas = mapearDTO(nuevoUser);
		
		
		return userRespuestas;
	}

	@Override
	public UserRespuestaDTO obtenerTodosLosUsuarios(int numerodePagina, int medidaDePagina, String ordenarPor,
			String sortDir) {

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(ordenarPor).ascending()
				: Sort.by(ordenarPor).descending();
		
		Pageable pageable = PageRequest.of(numerodePagina, medidaDePagina, sort);
		
		Page<User> users =  userrepo.findAll(pageable);
		
		List<User> listadeUsers = users.getContent();
		List<UserDTO> contenido = listadeUsers.stream().map(user -> mapearDTO(user)).collect(Collectors.toList());
		
		UserRespuestaDTO userRespuesta = new UserRespuestaDTO();
		userRespuesta.setContenido(contenido);
		userRespuesta.setNumeroPagina(users.getNumber());
		userRespuesta.setMedidaPagina(users.getSize());
		userRespuesta.setTotalElementos(users.getTotalElements());
		userRespuesta.setTotalPaginas(users.getTotalPages());
		userRespuesta.setUltima(users.isLast());
		
		
		return userRespuesta;
	}

	
	@Override
	public UserDTO obtenerUserPorID(long userId) {
		return mapearDTO(user);
	}
	/*
	/*@Override
	public List<User> listarUsuarios() {
		return (List<User>) userrepo.findAll();
	}

	@Override
	public User insertaActualizaUser(User user) {
		return userrepo.save(user);
	}
	*/
	
	private UserDTO mapearDTO(User user) {
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		
		return userDTO;
	}
	
	private User mapearEntidad(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		
		return user;
	}

	@Override
	public List<User> listarUsuarios() {
		return userrepo.findAll();
	}

	@Override
	public User registrar(User bean) {
		return userrepo.save(bean);
	}

	@Override
	public User buscar(Long cod) {
		return userrepo.findById(cod).orElse(null);
	}

	

	

}
