package com.chandu.student_management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "student_id_generator")
    @SequenceGenerator(name = "student_id_generator", sequenceName = "student_id_seq", allocationSize = 50)
    private Long id;
    private String name;
    private int age;
    private String email;
    private String course;
}
