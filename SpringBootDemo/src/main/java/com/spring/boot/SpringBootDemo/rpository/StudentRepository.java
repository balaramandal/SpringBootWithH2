package com.spring.boot.SpringBootDemo.rpository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.SpringBootDemo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
