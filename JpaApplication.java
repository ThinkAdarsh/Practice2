package com.springdemo.Jpa;

import com.springdemo.Jpa.MODEL.Address;
import com.springdemo.Jpa.MODEL.Employee;
import com.springdemo.Jpa.REPOSITORY.Emp_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Autowired
	private Emp_Repository emp_repository;

//	@Override
//	public void run(String... args) throws Exception {
//
//		Employee emp= new Employee();
//		emp.setId(1);
//		emp.setName("Adarsh kumar");
//		emp.setLanguage("Java");
//		emp.setCity("Bhubaneswar");
//		emp.setJoiningDate("1st Nov 2022");
//
//		Address address=new Address();
//		address.setLocation("Pune");
//
//		emp.setAddress((List<Address>) address);
//
//		emp_repository.save(emp);




		}





