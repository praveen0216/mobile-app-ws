package com.scratchdeveloper.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
	
	@NotNull(message = "firstName should not be null")
	@Size(min = 2, max =30,message = "firstName should be between 2 to 30 letter")
	private String firstName;
	
	@NotNull(message = "lastName should not be null")
	@Size(min = 2, max =30,message = "lastName should be between 2 to 30 letter")
	private String lastName ;
	
	@NotNull(message = "email should not be null")
	@Size(min = 1, max =25,message = "email should be between 2 to 25 letter")
	@Email
	private String email ;
	
	@NotNull(message = "userId should not be null")
	@Size(min = 8, max =16 ,message = "userId should be between 2 to 30 letter")
	private String password;
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
