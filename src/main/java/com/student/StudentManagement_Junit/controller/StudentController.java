package com.student.StudentManagement_Junit.controller;

import com.student.StudentManagement_Junit.model.Student;
import com.student.StudentManagement_Junit.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepo srepo;

    @PostMapping("/saveStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        Student addStudent = srepo.save(student);
        return ResponseEntity.ok(addStudent);
    }

    @GetMapping("/allStudents")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> getStudents = srepo.findAll();
        return ResponseEntity.ok(getStudents);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
         srepo.deleteById(id);
         return ResponseEntity.ok("Student details deleted Successfully!!!");
    }
}
