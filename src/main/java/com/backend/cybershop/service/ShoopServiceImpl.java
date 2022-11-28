package com.backend.cybershop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.cybershop.entity.Shoop;
import com.backend.cybershop.repository.ShoopDAO;
import com.backend.cybershop.service.interfaces.ShoopService;

@Service
public class ShoopServiceImpl implements ShoopService {

	@Autowired
	private ShoopDAO shooprepo; 
	
	
	@Override
	public List<Shoop> listarTiendas() {
		return (List<Shoop>) shooprepo.findAll();
	}

	
	
}
