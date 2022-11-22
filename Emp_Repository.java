package com.springdemo.Jpa.REPOSITORY;

import com.springdemo.Jpa.MODEL.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Emp_Repository extends JpaRepository<Employee, Integer> {
      List<Employee> getEmployeeByCity(String city);

      List<Employee> getEmployeeByLanguage(String language);
}
