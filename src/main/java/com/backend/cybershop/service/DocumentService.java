package com.backend.cybershop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.cybershop.dto.DocumentUserDTO;
import com.backend.cybershop.repository.DocumentDAO;
import com.backend.cybershop.service.interfaces.IDocumentService;

@Service
public class DocumentService implements IDocumentService {
	@Autowired
	private DocumentDAO repo;

	@Override
	public List<DocumentUserDTO> getDocuments() {
		List<DocumentUserDTO> data = repo.findAll().stream()
				.map((doc) -> new DocumentUserDTO(doc.getDocumentId(), doc.getDescription()))
				.collect(Collectors.toList());
		return data;
	}

}