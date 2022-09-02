package com.example.demo.one2many;

import javax.persistence.FetchType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2many.twoway.MenuItem;
import com.example.demo.repository.MenuGroupRepository;
import com.example.demo.repository.MenuItemRepository;

@SpringBootTest
public class QueryTest1 {
	
	@Autowired
	MenuGroupRepository menuGroupRepository;
	
	@Autowired
	MenuItemRepository menuItemRepository;
	
	@Test
	public void test() {
		MenuItem m1 = menuItemRepository.findById(1L).get();
		System.out.println(m1.getName());
		// 注意: fetch = FetchType.LAZY 預設不加載, 但若執行時期需要實施加載策略, 必須在 application.yml 中加入
		// enable_lazy_load_no_trans: true
		System.out.println(m1.getMenuGroup().getName());
		
	}
}
