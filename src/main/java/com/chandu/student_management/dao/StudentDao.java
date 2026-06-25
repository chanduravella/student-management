package com.chandu.student_management.dao;

import com.chandu.student_management.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<StudentEntity, Long> {
}
