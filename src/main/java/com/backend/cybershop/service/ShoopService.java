package com.backend.cybershop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.cybershop.dto.ShoopUserDTO;
import com.backend.cybershop.repository.ShoopDAO;
import com.backend.cybershop.service.interfaces.IShoopService;

@Service
public class ShoopService implements IShoopService {
	@Autowired
	private ShoopDAO repo;
	
	@Override
	public List<ShoopUserDTO> getShoops() {
		List<ShoopUserDTO> data = repo.findAll().stream()
				.map((shoop) -> new ShoopUserDTO(shoop.getShoopId(), shoop.getAddress())).collect(Collectors.toList());
		return data;
	}
}