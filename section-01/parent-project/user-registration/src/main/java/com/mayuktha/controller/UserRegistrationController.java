package com.mayuktha.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mayuktha.config.properties.UserContactInfoProperties;
import com.mayuktha.userregistration.constants.Constants;
import com.mayuktha.userregistration.dto.AddressDto;
import com.mayuktha.userregistration.dto.UserDto;
import com.mayuktha.userregistration.response.ApiResponse;
import com.mayuktha.userregistration.service.IUsersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/users",produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserRegistrationController {

	@Autowired
	IUsersService iUsersService;
	
	@Autowired
	UserContactInfoProperties userContactInfoProperties;
	
	@Autowired
	Environment environment;  // Environment variables are OS level properties like PATH,CLASSPATH,JAVA_HOME
	
	private static final Logger log = LoggerFactory.getLogger(UserRegistrationController.class);
	
	@Value("${build.version}")
	private String buildVersion;
	
	@GetMapping
	public String info() {
		

		return "User Registration Service";
	}
	
	@GetMapping(path = "fetchAll")
	public ResponseEntity<Object> fetchAll() {
		ApiResponse<List<UserDto>> apiResponse=new ApiResponse<>();
		apiResponse.setStatusCode(HttpStatus.OK.value());
		apiResponse.setStatus("SUCCESS");
		List<UserDto> userList=iUsersService.fetchAllUsers();
		apiResponse.setData(userList);
		
		
		return ResponseEntity.ok().body(apiResponse);
	}
	  
	@PostMapping
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserDto userDto) {
		log.debug("UserRegistrationController::::createUser::::"+userDto);
		iUsersService.createUser(userDto);
		ApiResponse<String> apiResponse=new ApiResponse<>();
		apiResponse.setStatusCode(HttpStatus.CREATED.value());
		apiResponse.setStatus("SUCCESS");
		apiResponse.setMessage("Record Has been Successfully Created");
		return ResponseEntity.ok().body(apiResponse);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
		iUsersService.deleteUser(id);
		ApiResponse<String> apiResponse=new ApiResponse<>();
		apiResponse.setStatusCode(HttpStatus.NO_CONTENT.value());
		apiResponse.setStatus("SUCCESS");
		apiResponse.setMessage("Record Has been Successfully Deleted.");
		return ResponseEntity.noContent().build().ofNullable(apiResponse);
	}
	
	@PutMapping
	public ResponseEntity<Object> updateUser(@RequestBody UserDto userDto) {
		
		log.debug("UserRegistrationController::::updateUser::::"+userDto);
		boolean isUpdated = iUsersService.updateUser(userDto);
		ApiResponse<String> apiResponse=new ApiResponse<>();
		if(isUpdated) {
			apiResponse.setStatusCode(HttpStatus.OK.value());
			apiResponse.setStatus("SUCCESS");
			apiResponse.setMessage(Constants.STATUS_200);
		}else {
			apiResponse.setStatusCode(HttpStatus.OK.value());
			apiResponse.setStatus(HttpStatus.EXPECTATION_FAILED.toString());
			apiResponse.setMessage(Constants.MESSAGE_417_UPDATE);
		}
		
		return ResponseEntity.ok().body(apiResponse);
	}
	@GetMapping(path = "contact")
	public ResponseEntity<Object> contactInfo() {
		// userContactInfoProperties
		return ResponseEntity.ok().body(userContactInfoProperties);
		
	}
	@GetMapping(path = "build")
	public ResponseEntity<Object> buildVersion() {
		return ResponseEntity.ok().body(buildVersion);
	}
	@GetMapping(path  = "env")
	public ResponseEntity<Object> envVariable() {
		return ResponseEntity.ok().body(environment.getProperty("JAVA_HOME"));
	}
}
