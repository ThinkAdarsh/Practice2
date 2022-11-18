package com.crudoperation.Crud2.Controller;


import com.crudoperation.Crud2.Entity.Student;
import com.crudoperation.Crud2.Exception.ResourcenotFound;
import com.crudoperation.Crud2.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/student")
public class StudentController {

    @Autowired
   private StudentService studentService;

    @GetMapping
    public List<Student> getAllstudent()
    {
        return studentService.getallStudent();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student)
    {
       return studentService.createstudent(student);
    }

    @GetMapping("{id}")
    public Student getStudentbyId(@PathVariable int id)
    {
        return studentService.getStudentbyid(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student studentdetails)
    {
        Student student= studentService.updateStudent(id,studentdetails);
            return ResponseEntity.ok().body(student);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteEmployee(@PathVariable int id){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }









}
