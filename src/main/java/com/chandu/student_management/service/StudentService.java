package com.chandu.student_management.service;

import com.chandu.student_management.dao.StudentDao;
import com.chandu.student_management.entity.StudentEntity;
import com.chandu.student_management.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<StudentEntity> getAllStudents() {
        return studentDao.findAll();
    }

    public StudentEntity saveStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(student.getName());
        studentEntity.setEmail(student.getEmail());
        return studentDao.save(studentEntity);
    }
}
