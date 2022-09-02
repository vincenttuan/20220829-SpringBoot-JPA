package com.example.demo.many2one;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.many2one.oneway.Customer;
import com.example.demo.entity.many2one.oneway.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class QueryTest {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void test() {
		// 因為是多對一, 所以預設 fetch = FetchType.EAGER, 查詢時會連同 "1" 的一方一併查出
		// sql 會使用 left outer join
		Order order = orderRepository.findById(1L).get();
		System.out.println(order.getName());
		System.out.println(order.getCustomer().getName());
		
	}
	
}
