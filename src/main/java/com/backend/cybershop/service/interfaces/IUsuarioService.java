package com.backend.cybershop.service.interfaces;

import java.util.List;

import com.backend.cybershop.dto.RegisterUserDTO;
import com.backend.cybershop.dto.RegisterUserResponseDTO;
import com.backend.cybershop.dto.UserListItemDTO;
import com.backend.cybershop.entity.User;

public interface IUsuarioService {
	public RegisterUserResponseDTO saveUser(RegisterUserDTO bean);
	public String updateUser(RegisterUserDTO bean, long id);
	public String deleteUser(long id);
	public User getUserById(long id);
	public List<UserListItemDTO> getAllUsers(String names, int roleId, int shoopId);
	public User getUserByUsername(String userNickName);
}