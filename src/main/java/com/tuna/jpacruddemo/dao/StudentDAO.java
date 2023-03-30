package com.tuna.jpacruddemo.dao;

import com.tuna.jpacruddemo.entity.Student;

public interface StudentDAO {
	void save(Student theStudent);
	
	Student findById(int id);
}
