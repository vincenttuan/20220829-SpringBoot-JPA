package com.example.demo.many2one;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.many2one.oneway.Customer;
import com.example.demo.entity.many2one.oneway.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class CreateTest {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void test() {
		Customer c1 = new Customer();
		c1.setName("John");
		c1.setAge(20);
		
		Customer c2 = new Customer();
		c2.setName("Mary");
		c2.setAge(19);
		
		Order o1 = new Order();
		o1.setName("A-1");
		
		Order o2 = new Order();
		o2.setName("B-2");
		
		Order o3 = new Order();
		o3.setName("C-3");
		
		// 設置關聯關係
		o1.setCustomer(c1);
		o2.setCustomer(c1);
		o3.setCustomer(c2);
		
		
		
	}
	
}
