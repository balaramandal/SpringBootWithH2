package com.spring.boot.SpringBootDemo.Handller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.boot.SpringBootDemo.Utility.Messages;
import com.spring.boot.SpringBootDemo.model.ResponseEntityModel;

@ControllerAdvice
public class ExceptionHandller {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ResponseEntityModel<Object>> hadleException(Exception ex){
		return new ResponseEntity<ResponseEntityModel<Object>>(new ResponseEntityModel<>(new Date(), Messages.INERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value()
				),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
