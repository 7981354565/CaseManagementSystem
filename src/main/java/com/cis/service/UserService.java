package com.cis.service;

import com.cis.dto.ApiResponse;
import com.cis.dto.UsersDto;

public interface UserService {

	ApiResponse saveUsers(UsersDto usersDto);

	ApiResponse updatePassword(UsersDto usersDto);
	
}
