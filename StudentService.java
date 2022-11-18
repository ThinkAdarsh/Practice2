package com.crudoperation.Crud2.Service;

import com.crudoperation.Crud2.Entity.Student;
import com.crudoperation.Crud2.Exception.ResourcenotFound;
import com.crudoperation.Crud2.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements ServiceInterface {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> getallStudent()
    {
        return studentRepository.findAll();
    }

    @Override
    public Student createstudent(Student student)
    {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentbyid(int id)
    {
        return studentRepository.findById(id).get();
    }

    @Override
   public Student updateStudent(int id, Student student)
    {
        Student updatestu= studentRepository.findById(id).orElseThrow(()->new ResourcenotFound("id doesnt exist"));
        updatestu.setName(student.getName());
        updatestu.setEmail(student.getEmail());
        updatestu.setCollege(student.getCollege());
        return studentRepository.save(updatestu);
    }

    @Override
    public Student deleteStudent(int id) {
        Student deletestu= studentRepository.findById(id).orElseThrow(()->new ResourcenotFound("id not found"));
        studentRepository.delete(deletestu);
        return deletestu;
    }


}
