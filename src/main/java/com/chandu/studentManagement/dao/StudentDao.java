package com.chandu.studentManagement.dao;

import com.chandu.studentManagement.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<StudentEntity, Long> {
}
