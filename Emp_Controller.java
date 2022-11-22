package com.springdemo.Jpa.CONTROLLER;

import com.springdemo.Jpa.MODEL.Employee;
import com.springdemo.Jpa.SERVICE.Service_Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/Employee")
public class Emp_Controller {

    @Autowired
    private Service_Employee service_employee;

    @GetMapping
    public List<Employee> getAllEmployee()
    {
        return service_employee.getAllEmployee();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee)
    {
        return service_employee.createEmployee(employee);
    }

    @GetMapping("{Id}")
    public Employee getEmployeeById(@PathVariable int Id)
    {
        return service_employee.getEmployeeById(Id);
    }

    @PutMapping("{Id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int Id, @RequestBody Employee employeedetails)
    {
        Employee employee=service_employee.updateEmployee(Id, employeedetails);
        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping("{Id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int Id){
        return ResponseEntity.ok().body(service_employee.deleteEmployee(Id));
    }

    @GetMapping("city/{city}")
    public List<Employee> getEmployeeByCity(@PathVariable String city)
    {
             return service_employee.getEmployeeByCity(city);
    }

    @GetMapping("language/{language}")
    public List<Employee> getEmployeeByLanguage(@PathVariable String language)
    {
        return service_employee.getEmployeeByLanguage(language);
    }


}
