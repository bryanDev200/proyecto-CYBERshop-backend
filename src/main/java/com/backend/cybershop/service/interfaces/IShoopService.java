package com.backend.cybershop.service.interfaces;

import java.util.List;

import com.backend.cybershop.dto.ShoopUserDTO;

public interface IShoopService {
	public List<ShoopUserDTO> getShoops();
}