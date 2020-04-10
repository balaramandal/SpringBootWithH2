package com.spring.boot.SpringBootDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.SpringBootDemo.model.Student;
import com.spring.boot.SpringBootDemo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	@GetMapping("/sayHello")
	public ResponseEntity<Object> sayHello(){
		return new ResponseEntity<Object>("Hello Balaram",HttpStatus.OK);
	}
	
	@PostMapping("/saveStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		Student savedObj = studentService.save(student);
		return new ResponseEntity<>(savedObj,HttpStatus.OK); 
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> allRecords = studentService.findAll();
		return new ResponseEntity<List<Student>>(allRecords,HttpStatus.OK);
	}
	
	@GetMapping("/findByProperties/{order}/{property}")
	public ResponseEntity<List<Student>> getAllByProperties(@PathVariable("order") String order,@PathVariable("property") String property){
		List<Student> allRecords = studentService.findAllByProperties(order,property);
		return new ResponseEntity<List<Student>>(allRecords, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
		studentService.remove(id);
		return new ResponseEntity<String>("SUCESSFULLY REMOVED",HttpStatus.OK);
	}
}
