package com.example.demo.one2many;

import javax.persistence.CascadeType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2many.twoway.MenuGroup;
import com.example.demo.entity.one2many.twoway.MenuItem;
import com.example.demo.repository.MenuGroupRepository;
import com.example.demo.repository.MenuItemRepository;

@SpringBootTest
public class CreateTest2_3 {
	
	@Autowired
	MenuGroupRepository menuGroupRepository;
	
	@Autowired
	MenuItemRepository menuItemRepository;
	
	@Test
	public void test() {
		MenuGroup g = new MenuGroup();
		g.setName("三號餐");
		
		MenuItem m1 = new MenuItem();
		m1.setName("果汁");
		m1.setPrice(25);
		
		MenuItem m2 = new MenuItem();
		m2.setName("熱狗堡");
		m2.setPrice(30);
		
		// 設置關聯關係 
		// 因為在 1 的一方有設定 mappedBy 所以下面二行可以不用撰寫
		g.getItems().add(m1); // MenuGroup 聯級新增時此行要加入
		g.getItems().add(m2); // MenuGroup 聯級新增時此行要加入
		m1.setMenuGroup(g);
		m2.setMenuGroup(g);
		
		// 執行保存動作 (聯級新增, 1的一方與多的一方都會被新增)
		// 在 MenuGroup 1 的一方加上 cascade = CascadeType.PERSIST
		menuGroupRepository.save(g);
	}
}
