package com.spring.boot.SpringBootDemo.model;

import java.util.Date;

public class ResponseEntityModel<data> {
	private data data;
	private Date date;
	private String message;
	private Integer statusCode;
	
	public data getData() {
		return data;
	}
	public void setData(data data) {
		this.data = data;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public ResponseEntityModel(Date date, String message, Integer statusCode) {
		super();
		this.date = date;
		this.message = message;
		this.statusCode = statusCode;
	}
	public ResponseEntityModel(data data, Date date, String message, Integer statusCode) {
		super();
		this.data = data;
		this.date = date;
		this.message = message;
		this.statusCode = statusCode;
	}
}
