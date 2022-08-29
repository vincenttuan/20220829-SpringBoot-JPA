package com.example.demo.one2one;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2one.Department;
import com.example.demo.entity.one2one.Manager;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ManagerRepository;

@SpringBootTest
public class CreateTest {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Test
	void test() {
		Manager manager = new Manager();
		manager.setName("John");
		Department department = new Department();
		department.setName("IT");
		
		// 設置關聯關係
		department.setManager(manager);
		
		// 保存資料
		managerRepository.save(manager);
		departmentRepository.save(department);
		
		System.out.println("Add OK");
	}
	
}
