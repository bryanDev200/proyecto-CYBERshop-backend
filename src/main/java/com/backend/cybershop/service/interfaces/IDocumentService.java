package com.backend.cybershop.service.interfaces;

import java.util.List;

import com.backend.cybershop.dto.DocumentUserDTO;

public interface IDocumentService {
	public List<DocumentUserDTO> getDocuments();
}