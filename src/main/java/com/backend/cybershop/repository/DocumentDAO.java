package com.backend.cybershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.cybershop.entity.Document;

@Repository
public interface DocumentDAO extends JpaRepository<Document, Long> {
	
}