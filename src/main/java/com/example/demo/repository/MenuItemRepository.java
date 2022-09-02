package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.one2many.twoway.MenuGroup;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuGroup, Long> {
	
}
