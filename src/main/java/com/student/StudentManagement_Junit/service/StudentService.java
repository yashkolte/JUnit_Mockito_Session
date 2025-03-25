package com.student.StudentManagement_Junit.service;

import com.student.StudentManagement_Junit.model.Student;
import com.student.StudentManagement_Junit.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService  {

    @Autowired
    private StudentRepo studentRepo;

    public Student addStudent(Student student){
        Student addStudent = studentRepo.save(student);
        return addStudent;
    }

    public List<Student> getStudents(){
        List<Student> students = studentRepo.findAll();
        return students;
    }

    public void deleteStudent(Integer id){
        studentRepo.deleteById(id);
    }

}
