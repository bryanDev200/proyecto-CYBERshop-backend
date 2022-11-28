package com.backend.cybershop.repository;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
=======
import org.springframework.data.repository.CrudRepository;
>>>>>>> cf0e39efa6ed7b080680e5d5d51826abb6d5d794
import org.springframework.stereotype.Repository;

import com.backend.cybershop.entity.Document;

@Repository
<<<<<<< HEAD
public interface DocumentDAO extends JpaRepository<Document, Long> {
	
}
=======
public interface DocumentDAO  extends CrudRepository<Document, Long>{

}
>>>>>>> cf0e39efa6ed7b080680e5d5d51826abb6d5d794
