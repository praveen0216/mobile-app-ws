package com.scratchdeveloper.app.ws.userservice;

import com.scratchdeveloper.app.ws.ui.model.request.UserDetailsRequestModel;
import com.scratchdeveloper.app.ws.ui.model.response.UserRest;

public interface UserService {
	
	UserRest createUser(UserDetailsRequestModel userDetails);

}
