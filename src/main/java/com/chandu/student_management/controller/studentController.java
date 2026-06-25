package com.chandu.student_management.controller;

import com.chandu.student_management.entity.StudentEntity;
import com.chandu.student_management.model.Student;
import com.chandu.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class studentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentEntity>> getAllStudents() {

        List<StudentEntity> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PostMapping("/addNewStudent")
    public ResponseEntity<StudentEntity> addNewStudent(Student student) {
        StudentEntity savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);
    }
}
