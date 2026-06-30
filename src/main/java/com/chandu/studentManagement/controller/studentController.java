package com.chandu.studentManagement.controller;

import com.chandu.studentManagement.entity.StudentEntity;
import com.chandu.studentManagement.model.Student;
import com.chandu.studentManagement.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/students")
public class studentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentEntity>> getAllStudents() {

        log.info("Request received to get all students");

        List<StudentEntity> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PostMapping("/addNewStudent")
    public ResponseEntity<StudentEntity> addNewStudent(Student student) {
        log.info("Request received to add a new student: {}", student);
        StudentEntity savedStudent = studentService.saveStudent(student);
        log.info("Student added successfully");
        return ResponseEntity.ok(savedStudent);
    }
}
