package com.tuna.jpacruddemo.dao;

import com.tuna.jpacruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class studentDAOImpl implements StudentDAO {
	
	// Define field for entity manager
	private EntityManager entityManager;
	
	// Inject entity manager using constructor injection
	
	@Autowired
	public studentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	//implement save method
	@Transactional
	@Override
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}
	
	@Override
	public Student findById(int id) {
		return entityManager.find(Student.class, id);
	};
}
