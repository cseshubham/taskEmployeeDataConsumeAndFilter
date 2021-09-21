package com.example.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.DO.Data;
import com.example.task.service.CustomService;

@RestController
public class EmployeeController {
	
	@Autowired
	CustomService customService;
	
	
	@GetMapping("/employee/maxmin")
	public String getData() {
		
		System.out.println("getData inside controller");
		
		List<Data> dataList=customService.getData();
		System.out.println("dataList::"+dataList.toString());
		List<Data> filterDataList= customService.filterData(dataList);
		System.out.println(filterDataList.toString());
		
		return "Max Salary::"+filterDataList.get(0).toString()+"####Min Salary::"+filterDataList.get(1).toString();
	}


	
}
