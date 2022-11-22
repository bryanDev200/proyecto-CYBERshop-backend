package com.backend.cybershop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.cybershop.entity.Rol;
import com.backend.cybershop.repository.RolDAO;
import com.backend.cybershop.service.interfaces.RolService;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolDAO rolrepo;
	
	
	@Override
	public List<Rol> listarRoles() {
		return (List<Rol>) rolrepo.findAll();
	}


	

}
