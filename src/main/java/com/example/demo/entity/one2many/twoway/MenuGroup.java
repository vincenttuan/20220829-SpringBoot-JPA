package com.example.demo.entity.one2many.twoway;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menu_group")
public class MenuGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	// 雙向一對多
	// 1 的一方必須使用 mappedBy 來放棄維護關聯關係, 如此也不用 @JoinColumn
	@OneToMany(mappedBy = "menuGroup")
	private Set<MenuItem> items = new LinkedHashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<MenuItem> getItems() {
		return items;
	}

	public void setItems(Set<MenuItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "MenuGroup [id=" + id + ", name=" + name + ", items=" + items + "]";
	}
	
	
	
}
