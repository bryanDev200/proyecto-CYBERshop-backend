package com.backend.cybershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.cybershop.entity.Document;
import com.backend.cybershop.service.interfaces.DocumentService;

@RestController
@RequestMapping("/url/documentos")
public class DocumentController {

	@Autowired
	private DocumentService docservice;
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Document>> listaDocument(){
		List<Document> lista = docservice.listarDocumentos();
		return ResponseEntity.ok(lista);
	}
	
}
