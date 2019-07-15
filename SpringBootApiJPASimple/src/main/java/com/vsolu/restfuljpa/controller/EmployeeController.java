package com.vsolu.restfuljpa.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vsolu.restfuljpa.exception.ResourceNotFoundException;
import com.vsolu.restfuljpa.model.Employee;
import com.vsolu.restfuljpa.model.ResponseChatbot;
import com.vsolu.restfuljpa.payload.SystemRequest;
import com.vsolu.restfuljpa.payload.SystemResponse;
import com.vsolu.restfuljpa.repository.EmployeeRepository;

@RestController
@RequestMapping(value="/api/v1")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	//select
	@GetMapping("/employees/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable(value="id") Long employeeId) 
			throws ResourceNotFoundException{
		
		Employee emp = employeeRepository.findById(employeeId)
						.orElseThrow(()->new ResourceNotFoundException("Employee not found for this id::"+employeeId));
		
		return ResponseEntity.ok().body(emp);
	}
	//create
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee ) {
		
		return employeeRepository.save(employee);
	}
	//update 
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		
		employee.setEmail(employeeDetails.getEmail());
		employee.setFirstname(employeeDetails.getFirstname());
		employee.setLastname(employeeDetails.getLastname());

		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	//system test
	
	@PostMapping("/system")
	public Map<String,String > checkSystemUser(@Valid @RequestBody SystemRequest systemrequest){
		
		SystemResponse response = new SystemResponse();
		Map<String,String>responseMap = new HashMap<>();
		
		if(systemrequest.getUserId().equalsIgnoreCase("tle.hung")
		  && systemrequest.getSystem().equalsIgnoreCase("SPA")) {
			responseMap.put("ErrorCode", "200");
			responseMap.put("message", "Success");
			responseMap.put("checkCode", "33333");
			
		}else if(systemrequest.getUserId().equalsIgnoreCase("tle.hung")
		  && systemrequest.getSystem().equalsIgnoreCase("SPA")) {
				responseMap.put("ErrorCode", "200");
				responseMap.put("message", "Success");
				responseMap.put("checkCode", "33333");
		}else {
			responseMap.put("ErrorCode", "401");
			responseMap.put("message", "Unsucess");
//			responseMap.put("checkCode", "33333");
		}
		
		return responseMap;
	}
	
	@PostMapping("/systemcheck")
	public ResponseEntity<ResponseChatbot> checkChatbot(@Valid @RequestBody SystemRequest systemrequest) {

		Gson gson = new Gson();
		String response = "";
		ResponseChatbot _res = new ResponseChatbot();
		
		HashMap<String, String> _attributes = new HashMap<>();
		
		if(!systemrequest.getAction().equalsIgnoreCase("checkUserId")) {
			_attributes.put("checkStatus", "Success");
			_attributes.put("smessage", "vui long nhap otp");
		}else {
			_attributes.put("checkStatus", "Fail");
			_attributes.put("smessage", "system hoac userid khong hop le");
		}
		
		_res.setAttributes(_attributes);

		List<HashMap<String, String>> _listmessagechatbot = new ArrayList<>();
		HashMap<String, String> _messagechatbot = new HashMap<>();
		_messagechatbot.put("type", "text");
		_listmessagechatbot.add(_messagechatbot);

		_res.setMessagechatbot(_listmessagechatbot);
		  response  =   gson.toJson(_res);
         System.out.println(response);
		return ResponseEntity.ok(_res);
	}
}
