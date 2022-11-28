package com.backend.cybershop.controller;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.backend.cybershop.dto.DocumentUserDTO;
	import com.backend.cybershop.service.interfaces.IDocumentService;

@RestController
@RequestMapping("/api/document")
@CrossOrigin(origins = "*")
public class DocumentController {
	@Autowired
	private IDocumentService docService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllDocs(){
		HashMap<String, Object> response = new HashMap<>();
		List<DocumentUserDTO> data = docService.getDocuments();
		if(data.size() > 0) {
			response.put("data", data);
		}else {
			response.put("message", "No existen documentos registrados");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
=======
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
>>>>>>> cf0e39efa6ed7b080680e5d5d51826abb6d5d794
