package com.backend.cybershop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.cybershop.dto.RolUserDTO;
import com.backend.cybershop.repository.RolDAO;
import com.backend.cybershop.service.interfaces.IRolService;

@Service
public class RolService implements IRolService {
	@Autowired
	private RolDAO repo;
	
	@Override
	public List<RolUserDTO> getRoles() {
		List<RolUserDTO> data = repo.findAll().stream()
				.map((rol) -> new RolUserDTO(rol.getRolId(), rol.getRolName())).collect(Collectors.toList());
		return data;
	}
}