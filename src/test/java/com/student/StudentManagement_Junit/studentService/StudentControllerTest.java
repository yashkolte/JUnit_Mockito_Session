package com.student.StudentManagement_Junit.studentService;

import com.student.StudentManagement_Junit.model.Student;
import com.student.StudentManagement_Junit.repository.StudentRepo;
import com.student.StudentManagement_Junit.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

// ExtendWith(MockitoExtension.class) is used to enable Mockito in JUnit 5 tests
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    // @Mock creates a mock implementation of the StudentRepo
    @Mock
    StudentRepo studentRepo;

    // @InjectMocks injects the mock dependencies into the StudentService
    @InjectMocks // It automatically injects mocks created with @Mock or @Spy into the tested object.
            StudentService studentService;

    // Test method to verify the addStudent functionality using Mockito
    @Test
    void addStudentTest() {
        System.out.println("Student added successfully");

        // Creating a sample student object
        Student student = new Student();
        student.setId(1);
        student.setName("Yash");
        student.setAge(23);
        student.setMarks(98.0);

        // Mocking the behavior of the studentRepo.save method
        Mockito.when(studentRepo.save(student)).thenReturn(student);

        // Calling the actual method to test
        Student addStudent = studentService.addStudent(student);

        // Assertions to check if the expected and actual results match
        Assertions.assertEquals(student.getId(), addStudent.getId(), "Student ID should match");
        Assertions.assertEquals(student.getName(), addStudent.getName(), "Student Name should match");
        Assertions.assertEquals(student.getAge(), addStudent.getAge(), "Student Age should match");
        Assertions.assertEquals(student.getMarks(), addStudent.getMarks(), "Student Marks should match");

        // Verifying that the save method was called once with the student object
        Mockito.verify(studentRepo, Mockito.times(1)).save(student);
    }
}

