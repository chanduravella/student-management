package com.chandu.studentManagement.service;

import com.chandu.studentManagement.dao.StudentDao;
import com.chandu.studentManagement.entity.StudentEntity;
import com.chandu.studentManagement.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<StudentEntity> getAllStudents() {
        log.info("Fetching all students from database");
        return studentDao.findAll();
    }

    public void saveStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(student.getName());
        studentEntity.setEmail(student.getEmail());
        studentEntity.setAge(student.getAge());
        studentEntity.setCourse(student.getCourse());
        log.info("Saving student into database: {}", studentEntity);
        studentDao.save(studentEntity);
    }

    public void updateStudent(Long id, Student student) {
        log.info("Updating student with id: {}", id);
        StudentEntity existingStudent = studentDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setAge(student.getAge());
        existingStudent.setCourse(student.getCourse());
        log.info("Saving updated student into database: {}", existingStudent);
        studentDao.save(existingStudent);
    }

    public void deleteStudent(Long id) {
        log.info("Deleting student with id: {}", id);
        studentDao.deleteById(id);
    }
}
