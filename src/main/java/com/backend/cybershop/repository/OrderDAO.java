package com.backend.cybershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.cybershop.entity.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {

}