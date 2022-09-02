package com.example.demo.many2many;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.many2many.Course;
import com.example.demo.entity.many2many.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;

@SpringBootTest
public class CreateTest {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Test
	public void test() {
		Course c1 = new Course();
		c1.setName("Java");
		Course c2 = new Course();
		c2.setName("Python");
		Course c3 = new Course();
		c3.setName("VB");
		
		Student s1 = new Student();
		s1.setName("John");
		Student s2 = new Student();
		s2.setName("Mary");
		
		// 設置關聯關係
		// 由 Course 來維護關聯關係即可
		// 因為 Student 透過 mappedby = "students" 將維護關聯的權利放棄
		c1.getStudents().add(s1);
		c1.getStudents().add(s2);
		c2.getStudents().add(s1);
		c2.getStudents().add(s2);
		c3.getStudents().add(s2);
		
		studentRepository.save(s1);
		studentRepository.save(s2);
		courseRepository.save(c1);
		courseRepository.save(c2);
		courseRepository.save(c3);
		
		
	}
}
