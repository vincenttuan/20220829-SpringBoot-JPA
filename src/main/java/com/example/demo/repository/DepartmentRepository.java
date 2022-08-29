package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.one2one.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
}
