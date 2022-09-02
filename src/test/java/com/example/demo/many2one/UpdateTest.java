package com.example.demo.many2one;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.many2one.oneway.Customer;
import com.example.demo.entity.many2one.oneway.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class UpdateTest {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void test() {
		Order order = orderRepository.findById(1L).get();
		System.out.println(order.getCustomer().getName());
		// 變更 customer 名字由 "John" -> "Tom"
		Customer customer = order.getCustomer();
		customer.setName("Tom2");
		
		// 一般正常狀況
		//customerRepository.save(customer);
		
		// 若要存 order 去修改 customer 內容
		// 則必須要在 Order.java 中加入 @ManyToOne(cascade = CascadeType.MERGE) 聯級修改
		orderRepository.save(order);
		
	}
	
}
