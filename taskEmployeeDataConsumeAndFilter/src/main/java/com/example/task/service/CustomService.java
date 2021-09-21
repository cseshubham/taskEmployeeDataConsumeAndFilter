package com.example.task.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.task.DO.Data;
import com.example.task.DO.ResponseResult;


@Repository
public class CustomService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<Data>  getData() {
		
		List<Data> data = null;
		try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            ResponseEntity<ResponseResult> response = restTemplate.exchange("http://dummy.restapiexample.com/api/v1/employees", HttpMethod.GET,entity,ResponseResult.class);
            
           data=response.getBody().getData();
           
        } catch (Exception ex) {
           ex.printStackTrace();

        }
		return data;
	}
	
	public List<Data>  filterData(List<Data> data) {
	
		List<Data> filteData = new ArrayList<Data>();
		
		Optional<Data> maxSalaryEmp = 
	            data.stream()
	            .collect(Collectors.maxBy(Comparator.comparingDouble(Data::getEmployee_salary)));
	   
		System.out.println("Data with max salary:"
	            + (maxSalaryEmp.isPresent()? maxSalaryEmp.get():"Not Applicable"));
	    Optional<Data> minSalaryEmp =    
	            data.stream()
	            .collect(Collectors.minBy(Comparator.comparingDouble(Data::getEmployee_salary)));
	    System.out.println("Data with min salary:"
	            + (minSalaryEmp.isPresent()? minSalaryEmp.get():"Not Applicable"));
	    
	    Data d=maxSalaryEmp.get();
	    filteData.add(maxSalaryEmp.get());
	    filteData.add(minSalaryEmp.get());
	    System.out.println("final data list"+filteData.toString());
	    
		return filteData;
		
	}
}
