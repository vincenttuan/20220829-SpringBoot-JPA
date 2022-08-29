package com.example.demo.one2one;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2one.Department;
import com.example.demo.entity.one2one.Manager;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ManagerRepository;

@SpringBootTest
public class CreateTest2 {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Test
	void test() {
		Manager manager = managerRepository.findById(1L).get();
		System.out.println(manager.getName());
		
		Department department = new Department();
		department.setName("Sales");
		
		// 建立關聯關係
		department.setManager(manager);
		
		departmentRepository.save(department);
		
	}
	
}
