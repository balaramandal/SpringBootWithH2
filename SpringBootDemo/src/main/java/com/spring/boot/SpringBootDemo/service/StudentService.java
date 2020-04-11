package com.spring.boot.SpringBootDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.spring.boot.SpringBootDemo.model.Student;
import com.spring.boot.SpringBootDemo.rpository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepo;
	public Student save(Student student) {
		return studentRepo.save(student);
	}
	public List<Student> findAll(){
		return studentRepo.findAll();
	}
	public List<Student> findAllByProperties(String order,String property){
		return studentRepo.findAll(Sort.by(Direction.fromString(order), new String[]{property}));
	}
	public void remove(Long id) {
		studentRepo.deleteById(id);
	}
}
