package com.springdemo.Jpa.SERVICE;

import com.springdemo.Jpa.MODEL.Employee;

import java.util.List;

public interface Service_Interface {

    public List<Employee> getAllEmployee();

    public Employee createEmployee(Employee employee);

    public Employee getEmployeeById(int Id);

    public Employee updateEmployee(int Id, Employee employee);

    public Employee deleteEmployee(int Id);

    public List<Employee> getEmployeeByCity(String city);

    public List<Employee> getEmployeeByLanguage(String language);
}
