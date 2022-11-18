package com.crudoperation.Crud2.Service;

import com.crudoperation.Crud2.Entity.Student;

import java.util.List;

public interface ServiceInterface {

    public List getallStudent();
    public Student createstudent(Student student);
    public Student getStudentbyid(int id);
    public Student updateStudent(int id, Student student);

    public Student deleteStudent(int id);

}
