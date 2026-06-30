package com.chandu.studentManagement.controller;

import com.chandu.studentManagement.entity.StudentEntity;
import com.chandu.studentManagement.model.Student;
import com.chandu.studentManagement.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> addNewStudent(@RequestBody Student student) {
        log.info("Request received to add a new student: {}", student);
        studentService.saveStudent(student);
        log.info("Student added successfully");
        return ResponseEntity.ok("Student added successfully");
    }

    @PatchMapping("/updateStudent/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        log.info("Request received to update student with id: {}", id);
        studentService.updateStudent(id, student);
        log.info("Student updated successfully");
        return ResponseEntity.ok("Student updated successfully");
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        log.info("Request received to delete student with id: {}", id);
        studentService.deleteStudent(id);
        log.info("Student deleted successfully");
        return ResponseEntity.ok("Student deleted successfully");
    }
}
