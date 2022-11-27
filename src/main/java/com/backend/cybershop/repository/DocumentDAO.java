package com.backend.cybershop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.cybershop.entity.Document;

@Repository
public interface DocumentDAO  extends CrudRepository<Document, Long>{

}
