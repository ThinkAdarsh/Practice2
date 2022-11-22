package com.springdemo.Jpa.SERVICE;

import com.springdemo.Jpa.EXCEPTION.ResourcenotFound;
import com.springdemo.Jpa.MODEL.Employee;
import com.springdemo.Jpa.REPOSITORY.Emp_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Service_Employee implements Service_Interface{

    @Autowired
    private Emp_Repository emp_repository;




    @Override
    public List<Employee> getAllEmployee() {
        return  emp_repository.findAll();

    }

    @Override
    public Employee createEmployee(Employee employee) {
        return emp_repository.save(employee);

    }

    @Override
    public Employee getEmployeeById(int Id) {
        return  emp_repository.findById(Id).orElseThrow(()->new ResourcenotFound("Id doesnt exist"));

    }

    @Override
    public Employee updateEmployee(int Id, Employee employee) {
        Employee empUpdate=getEmployeeById(Id);
        empUpdate.setId(employee.getId());
        empUpdate.setName(employee.getName());
        empUpdate.setLanguage(employee.getLanguage());
        empUpdate.setCity(employee.getCity());
        empUpdate.setJoiningDate(employee.getJoiningDate());
        return emp_repository.save(empUpdate);

    }

    @Override
    public Employee deleteEmployee(int Id) {
        Employee empDelete= getEmployeeById(Id) ;
        emp_repository.delete(empDelete);
        return empDelete;

    }

    @Override
    public List<Employee> getEmployeeByCity(String city) {
        return  emp_repository.getEmployeeByCity(city);

    }

    @Override
    public List<Employee> getEmployeeByLanguage(String language) {
        return emp_repository.getEmployeeByLanguage(language);
    }
}
