package com.scratchdeveloper.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	

	@NotNull(message = "firstName should not be null")
	@Size(min = 2, max =30,message = "firstName should be between 2 to 30 letter")
	private String firstName;
	
	@NotNull(message = "lastName should not be null")
	@Size(min = 2, max =30,message = "lastName should be between 2 to 30 letter")
	private String lastName ;

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
	
	

}
