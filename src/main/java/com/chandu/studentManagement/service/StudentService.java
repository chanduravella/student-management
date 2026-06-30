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

    public StudentEntity saveStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(student.getName());
        studentEntity.setEmail(student.getEmail());
        log.info("Saving student into database: {}", studentEntity);
        return studentDao.save(studentEntity);
    }
}
