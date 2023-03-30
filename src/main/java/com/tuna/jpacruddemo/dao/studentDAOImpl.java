package com.tuna.jpacruddemo.dao;

import com.tuna.jpacruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
	}

	@Override
	public List<Student> findAll() {
		// create query
		TypedQuery<Student> theQuery = entityManager.createQuery("from Student order by lastName asc", Student.class);

		// return query
		return  theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String theLastName) {
		// create query
		TypedQuery<Student> theQuery = entityManager.createQuery("from Student where lastName=:theData", Student.class);
		// set query parameters
		theQuery.setParameter("theData", theLastName);
		// return query results
		return theQuery.getResultList();
	};
}
