package com.example.demo.entity.many2many;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@JoinTable(name = "course_student", 
			joinColumns = @JoinColumn(name="course_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="student_id", referencedColumnName = "id"))
	@ManyToMany
	private Set<Student> students = new LinkedHashSet<>();


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


	public Set<Student> getStudents() {
		return students;
	}


	public void setStudents(Set<Student> students) {
		this.students = students;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", students=" + students + "]";
	}
	
	
}
