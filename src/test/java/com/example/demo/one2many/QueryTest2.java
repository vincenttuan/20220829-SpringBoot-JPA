package com.example.demo.one2many;

import javax.persistence.FetchType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2many.twoway.MenuGroup;
import com.example.demo.entity.one2many.twoway.MenuItem;
import com.example.demo.repository.MenuGroupRepository;
import com.example.demo.repository.MenuItemRepository;

@SpringBootTest
public class QueryTest2 {
	
	@Autowired
	MenuGroupRepository menuGroupRepository;
	
	@Autowired
	MenuItemRepository menuItemRepository;
	
	@Test
	public void test() {
		MenuGroup g = menuGroupRepository.findById(1L).get();
		System.out.println(g.getName());
		// 注意: fetch = FetchType.LAZY 預設不加載, 但若執行時期需要實施加載策略, 必須在 application.yml 中加入
		// enable_lazy_load_no_trans: true
		System.out.println(g.getItems().size() + "個");
	}
}
