package com.backend.cybershop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.cybershop.dto.RegisterUserDTO;
import com.backend.cybershop.dto.RegisterUserResponseDTO;
import com.backend.cybershop.dto.UserListItemDTO;
import com.backend.cybershop.entity.Document;
import com.backend.cybershop.entity.Rol;
import com.backend.cybershop.entity.Shoop;
import com.backend.cybershop.entity.User;
import com.backend.cybershop.repository.UserDAO;
import com.backend.cybershop.service.interfaces.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {
	@Autowired
	private UserDAO repo;
	
	@Override
	public RegisterUserResponseDTO saveUser(RegisterUserDTO bean) {
		User userSave = new User();
		
		userSave.setUserNames(bean.getFirstName());
		userSave.setUserLastName(bean.getLastName());
		userSave.setUserPhone(bean.getPhone());
		userSave.setUserImage(bean.getImage());
		userSave.setUserNickName(bean.getUserName());
		userSave.setPassword(bean.getPassword());
		userSave.setDniNumber(bean.getDocNumber());
		userSave.setDocument(new Document(bean.getDocumentId()));
		userSave.setShoop(new Shoop(bean.getShoopId()));
		userSave.setUserRol(new Rol(bean.getRolId()));
		userSave.setEnabled(bean.isEnabled());
		
		User newUser = repo.save(userSave);
		
		RegisterUserResponseDTO userResponse = new RegisterUserResponseDTO(newUser.getUserId(),
				newUser.getUserNames(), newUser.getUserLastName(), newUser.getUserPhone(), newUser.getUserImage(),
				newUser.getUserNickName(), newUser.getPassword(), newUser.getDniNumber(), newUser.getUserRol(),
				newUser.getDocument(), newUser.getShoop(), newUser.isEnabled());
		return userResponse;
	}

	@Override
	public String updateUser(RegisterUserDTO bean, long id) {
		User userFound = repo.findById(id).orElse(null);
		if(userFound != null) {
			userFound.setUserImage(bean.getImage());
			userFound.setUserLastName(bean.getLastName());
			userFound.setUserNames(bean.getFirstName());
			userFound.setUserPhone(bean.getPhone());
			userFound.setDocument(new Document(bean.getDocumentId()));
			userFound.setDniNumber(bean.getDocNumber());
			userFound.setShoop(new Shoop(bean.getShoopId()));
			userFound.setUserRol(new Rol(bean.getRolId()));
			userFound.setEnabled(bean.isEnabled());
			
			User userSave = repo.save(userFound);
			if(userSave == null) {
				return "Error al actualizar los datos";
			}else {
				return "El usuario " + bean.getFirstName() + " ha sido editado correctamente";
			}
		}else {
			return "El usuario no ha sido encontrado";
		}
	}

	@Override
	public String deleteUser(long id) {
		User userFound = repo.findById(id).orElse(null);
		
		if(userFound != null) {
			try {
				repo.deleteById(id);
				return "Usuario eliminado correctamente";
			}catch(Exception e) {
				return "Error al eliminar usuario";
			}
		}else {
			return "El usuario no ha sido encontrado";
		}
	}

	@Override
	public User getUserById(long id) {
		try {
			User user = repo.findById(id).get();
			return user;
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<UserListItemDTO> getAllUsers(String names, int roleId, int shoopId) {
		List<UserListItemDTO> data = repo.getAllUserFilters(names, roleId, shoopId).stream()
				.map((user) -> new UserListItemDTO((int)user.getUserId(), user.getUserNames(),
						user.getUserLastName(), user.getUserRol().getRolDescription())).collect(Collectors.toList());
		return data;
	}
}
