package com.example.demo.one2many;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2many.oneway.Infect;
import com.example.demo.entity.one2many.oneway.Vaccine;
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
		infect.setName("COVID-19");
		Vaccine v1 = new Vaccine();
		v1.setName("AZ");
		v1.setCount(3);
		Vaccine v2 = new Vaccine();
		v2.setName("BNT");
		v2.setCount(2);
		Vaccine v3 = new Vaccine();
		v3.setName("PJ"); // 嬌生疫苗
		v3.setCount(1);
		
		// 設置關聯關係
		infect.getVaccines().add(v1);
		infect.getVaccines().add(v2);
		infect.getVaccines().add(v3);
		
		// 執行非聯集保存操作
		// @OneToMany
		// 因為是由 1 的一方來維護 多 方的關聯欄位(inflect_id), 所以會多增加 update 語句
		/*
		vaccineRepository.save(v1);
		vaccineRepository.save(v2);
		vaccineRepository.save(v3);
		infectRepository.save(infect);
		*/
		
		// 執行聯集保存操作
		// @OneToMany(cascade = CascadeType.PERSIST)
		infectRepository.save(infect);
		
	}
}
