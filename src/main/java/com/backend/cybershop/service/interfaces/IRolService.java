package com.backend.cybershop.service.interfaces;

	import java.util.List;

	import com.backend.cybershop.dto.RolUserDTO;

public interface IRolService {
	public List<RolUserDTO> getRoles();
}