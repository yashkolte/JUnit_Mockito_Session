package com.student.StudentManagement_Junit.repository;

import com.student.StudentManagement_Junit.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
