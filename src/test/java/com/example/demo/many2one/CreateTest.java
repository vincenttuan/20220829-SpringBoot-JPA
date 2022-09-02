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
		Customer c1 = new Customer("John");
		//Customer c2 = new Customer("Mary");
		
		Order o1 = new Order("A-1");
		Order o2 = new Order("B-2");
		//Order o3 = new Order("C-3");
		//Order o4 = new Order("D-4");
		
		// 設置關聯關係
		o1.setCustomer(c1);
		o2.setCustomer(c1);
		//o3.setCustomer(c2);
		//o4.setCustomer(c2);
		
		// 單向多對一執行保存操作
		// 先保存 "1" 的一方再保存 "多" 的一方
		// 會有 3 的 insert sql
		customerRepository.save(c1);
		orderRepository.save(o1);
		orderRepository.save(o2);
		
		// 單向多對一先保存 "多" 的一方再保存 "1" 的一方
		// 會發生新增失敗
		// orderRepository.save(o3);
		// orderRepository.save(o4);
		// customerRepository.save(c2);
		
	}
	
}
