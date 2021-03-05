package com.scratchdeveloper.app.ws.ui.controller;



import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scratchdeveloper.app.ws.exception.UserServiceException;
import com.scratchdeveloper.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.scratchdeveloper.app.ws.ui.model.request.UserDetailsRequestModel;
//import com.scratchdeveloper.app.ws.ui.model.response.UserPost_Self_Test;
import com.scratchdeveloper.app.ws.ui.model.response.UserRest;
import com.scratchdeveloper.app.ws.userservice.UserService;
import com.scratchdeveloper.app.ws.userservice.impl.UserServiceImpl;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
	
	Map<String , UserRest> users;
	
	@Autowired
	UserService userService;
	
	@GetMapping(path = "/{userID}" , produces = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> getUser(@PathVariable String userID) {
		
		/*
		 * String firstName=null;
		 * 
		 * int len=firstName.length();
		 */
		
		if(true) throw new UserServiceException("A user service exception is thrown");
		
		if(users.containsKey(userID)) {
			return new ResponseEntity<>(users.get(userID),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping()
	public String getUsers(@RequestParam(value="page" ,defaultValue="2", required=false) Integer page ,@RequestParam(value="limit" , defaultValue = "50",required = true) int limit ,
			@RequestParam(value = "sort" ,defaultValue="desc", required = false) String sort)  {
		
		return "get user was called page = " +page +" and limit = "+limit + " sort ="+sort;
	}
	
	/* done by me
	 * @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE
	 * ,MediaType.APPLICATION_JSON_VALUE} , produces =
	 * {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE}) public
	 * ResponseEntity<UserPost_Self_Test> createUser(@RequestBody(required = true) UserPost
	 * userPost){
	 * 
	 * return new ResponseEntity<UserPost_Self_Test>(userPost ,HttpStatus.CREATED);
	 * 
	 * }
	 */
	
	@PostMapping(consumes = {
			MediaType.APPLICATION_XML_VALUE ,
			MediaType.APPLICATION_JSON_VALUE
			} ,
			produces = {
			MediaType.APPLICATION_XML_VALUE ,
			MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody(required = true) UserDetailsRequestModel userDetails){
		
		UserRest returnValue=userService.createUser(userDetails);
		
		return new ResponseEntity<UserRest>(returnValue ,HttpStatus.OK);
		
	}
	
	@PutMapping(consumes = {
			MediaType.APPLICATION_XML_VALUE ,
			MediaType.APPLICATION_JSON_VALUE
			} ,
			produces = {
			MediaType.APPLICATION_XML_VALUE ,
			MediaType.APPLICATION_JSON_VALUE
			},path = "/{userID}" )
	public UserRest updateUser(@PathVariable String userID , @Valid @RequestBody(required = true) UpdateUserDetailsRequestModel userDetails ) {
	
		
		UserRest storedUserDetails = users.get(userID);
		storedUserDetails.setFirstName(userDetails.getFirstName());
		storedUserDetails.setLastName(userDetails.getLastName());
		
		users.put(userID, storedUserDetails);
		return storedUserDetails;
	}
	
	/*done by me: its working
	 * @DeleteMapping(path = "/{id}") public ResponseEntity<String>
	 * deleteUser(@PathVariable String id) {
	 * 
	 * return new ResponseEntity<String>(users.remove(id,
	 * users.get(id))==true?id:"not deleted: Id not available",HttpStatus.OK);
	 * 
	 * }
	 */
	@DeleteMapping(path = "/{id}") public ResponseEntity<Void>
	  deleteUser(@PathVariable String id) {
		users.remove(id);
	  return ResponseEntity.noContent().build();
	}
	
}
