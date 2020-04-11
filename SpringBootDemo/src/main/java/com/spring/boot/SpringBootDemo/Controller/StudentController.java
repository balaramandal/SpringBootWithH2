package com.spring.boot.SpringBootDemo.Controller;

import java.util.Date;
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

import com.spring.boot.SpringBootDemo.Utility.Messages;
import com.spring.boot.SpringBootDemo.model.ResponseEntityModel;
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
	public ResponseEntity<ResponseEntityModel<Student>> saveStudent(@RequestBody Student student){
		Student savedObj = studentService.save(student);
		return new ResponseEntity<ResponseEntityModel<Student>>(new ResponseEntityModel<Student>(savedObj, new Date(), Messages.CREATED_SUCESSFULLY, HttpStatus.OK.value()),HttpStatus.OK); 
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<ResponseEntityModel<List<Student>>> getAllStudent()throws Exception{
		List<Student> allRecords = studentService.findAll();
		return new ResponseEntity<>(new ResponseEntityModel<List<Student>>(allRecords, new Date(), Messages.RETRIVED_SUCESSFULLY,HttpStatus.OK.value()),HttpStatus.OK);
	}
	
	@GetMapping("/findByProperties/{order}/{property}")
	public ResponseEntity<ResponseEntityModel<List<Student>>> getAllByProperties(@PathVariable("order") String order,@PathVariable("property") String property)throws Exception{
		List<Student> allRecords = studentService.findAllByProperties(order,property);
		return new ResponseEntity<ResponseEntityModel<List<Student>>>(new ResponseEntityModel<List<Student>>(allRecords, new Date(), Messages.RETRIVED_SUCESSFULLY, HttpStatus.OK.value()), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<ResponseEntityModel<Object>> deleteById(@PathVariable("id") Long id){
		studentService.remove(id);
		return new ResponseEntity<ResponseEntityModel<Object>>(new ResponseEntityModel<>(new Date(), Messages.DELETED_SUCCESSFULLY, HttpStatus.OK.value()),HttpStatus.OK);
	}
}
