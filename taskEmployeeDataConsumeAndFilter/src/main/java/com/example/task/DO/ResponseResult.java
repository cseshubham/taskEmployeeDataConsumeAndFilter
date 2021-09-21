package com.example.task.DO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseResult {
	
	String status;
	List<Data> data;
	String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseResult [status=" + status + ", data=" + data + ", message=" + message + "]";
	}
	
	
	
}
