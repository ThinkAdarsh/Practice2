package com.crudoperation.Crud2;

import com.crudoperation.Crud2.Entity.Student;
import com.crudoperation.Crud2.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Crud2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Crud2Application.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

		Student student=new Student();
		student.setName("adarsh");
		student.setEmail("adarsh2@gmail.com");
		student.setCollege("GIFT");

		studentRepository.save(student);

	}
}
