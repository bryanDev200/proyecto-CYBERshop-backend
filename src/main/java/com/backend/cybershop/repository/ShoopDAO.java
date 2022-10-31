package com.backend.cybershop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.cybershop.entity.Shoop;

@Repository
public interface ShoopDAO extends CrudRepository<Shoop, Long>{}