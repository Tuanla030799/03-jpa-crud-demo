package com.tuna.jpacruddemo;

import com.tuna.jpacruddemo.dao.StudentDAO;
import com.tuna.jpacruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaCrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaCrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}
	
	private void createStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating student object...");
		Student tempStudent = new Student("Tuan", "Le", "tuanla0307@gmail.com");
		// save the student object
		System.out.println("Saving student object...");
		studentDAO.save(tempStudent);
		// display id of the saved student
		System.out.println("saved student. Generated id:" + tempStudent.getId());
		// display student
		System.out.println("Student:" + studentDAO.findById(tempStudent.getId()));
	};

}
