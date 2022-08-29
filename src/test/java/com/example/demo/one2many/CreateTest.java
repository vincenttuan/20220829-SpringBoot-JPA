package com.example.demo.one2many;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2many.Infect;
import com.example.demo.entity.one2many.Vaccine;
import com.example.demo.repository.InfectRepository;
import com.example.demo.repository.VaccineRepository;

@SpringBootTest
public class CreateTest {
	@Autowired
	InfectRepository infectRepository;
	
	@Autowired
	VaccineRepository vaccineRepository;
	
	@Test
	void test() {
		Infect infect = new Infect();
		Vaccine v1 = new Vaccine();
		v1.setName("AZ");
		v1.setCount(3);
		Vaccine v2 = new Vaccine();
		v2.setName("BNT");
		v2.setCount(2);
		Vaccine v3 = new Vaccine();
		v3.setName("PJ"); // 嬌生疫苗
		
		// 設置關聯關係
		infect.getVaccines().add(v1);
		infect.getVaccines().add(v2);
		infect.getVaccines().add(v3);
		
		
		
		
	}
}
