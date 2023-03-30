package com.tuna.jpacruddemo.dao;

import com.tuna.jpacruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
	void save(Student theStudent);
	
	Student findById(int id);

	List<Student> findAll();

	List<Student> findByLastName(String theLastName);
}
