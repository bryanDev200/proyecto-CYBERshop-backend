package com.backend.cybershop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.cybershop.entity.Document;
import com.backend.cybershop.repository.DocumentDAO;
import com.backend.cybershop.service.interfaces.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentDAO docrepo;
	
	@Override
	public List<Document> listarDocumentos() {
		return (List<Document>) docrepo.findAll();
	}

	
}
