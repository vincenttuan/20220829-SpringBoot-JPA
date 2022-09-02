package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.many2one.oneway.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
}
