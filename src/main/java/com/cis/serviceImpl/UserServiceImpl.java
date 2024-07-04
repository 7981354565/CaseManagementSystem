package com.cis.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cis.dto.ApiResponse;
import com.cis.dto.UsersDto;
import com.cis.entity.UsersEntity;
import com.cis.repository.UsersRepository;
import com.cis.service.UserService;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public ApiResponse saveUsers(UsersDto usersDto) {
	     // Check if usersDto is not null
        if (usersDto != null) {
        // Check if the username already exists
            Optional<UsersEntity> userOpt = usersRepository.findByUserName(usersDto.getUserName());
            if (userOpt.isPresent()) {
        // If username already exists, return ApiResponse indicating the conflict
                return new ApiResponse("Username already exists", HttpStatus.CONFLICT);
            } else {
        // If username does not exist, create a new user
                UsersEntity usersEntity = new UsersEntity();
                usersEntity.setUserName(usersDto.getUserName());
                usersEntity.setPassword(passwordEncoder.encode(usersDto.getPassword()));
                usersEntity.setEmail(usersDto.getEmail());
                usersEntity.setFullName(usersDto.getFullName());
                usersEntity.setId(usersDto.getId());
                usersEntity.setIsFirstLogin(usersDto.getIsFirstLogin());
                usersEntity.setLastPasswordUpdate(usersDto.getLastPasswordUpdate());
                usersEntity.setPhoneNumber(usersDto.getPhoneNumber());
                usersEntity.setRoles(usersDto.getRoles());
                usersRepository.save(usersEntity);
            }
        } else {
            // If usersDto is null, return ApiResponse indicating bad request
            return new ApiResponse("No data found to insert", HttpStatus.BAD_REQUEST);
        }
		return new ApiResponse("user was saved successfully", HttpStatus.FOUND);
	}

	@Override
	public ApiResponse updatePassword(UsersDto usersDto) {
	    // Check if usersDto is not null
	    if (usersDto != null) {
	        // Check if the username already exists
	        Optional<UsersEntity> userOpt = usersRepository.findByUserName(usersDto.getUserName());
	        if (userOpt.isPresent()) {
	            // If username exists, update the password
	            UsersEntity user = userOpt.get();
	            user.setPassword(passwordEncoder.encode(usersDto.getPassword()));
	            user.setIsFirstLogin(false);
	            usersRepository.save(user);
	            return new ApiResponse("Password reset successfully", HttpStatus.OK);
	        } else {
	            // If username does not exist, return ApiResponse indicating user not found
	            return new ApiResponse("User not found", HttpStatus.NOT_FOUND);
	        }
	    } else {
	        // If usersDto is null, return ApiResponse indicating bad request
	        return new ApiResponse("No data found to insert", HttpStatus.BAD_REQUEST);
	    }
	}

}
