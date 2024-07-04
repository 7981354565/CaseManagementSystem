package com.cis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cis.dto.ApiResponse;
import com.cis.dto.AuthRequest;
import com.cis.dto.UsersDto;
import com.cis.security.JwtService;
import com.cis.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
		
	@Autowired
	private JwtService jwtservice;
	
	
	@Autowired
	UserService userService;
	
	@PostMapping("/user-details")
	public ApiResponse saveUser(@RequestBody UsersDto usersDto) {
		return userService.saveUsers(usersDto);
	}
	
	@PostMapping("/update-password")
    public ResponseEntity<ApiResponse> updatePassword(@RequestBody UsersDto usersDto) {
        ApiResponse response = userService.updatePassword(usersDto);
        return new ResponseEntity<>(response, response.getStatus());
    }
	
	@PostMapping("/authenticate")
	public String authenticateAndetToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();

			return jwtservice.generateToken(userDetails);
		} else
			throw new UsernameNotFoundException("Invalid User");
	}
	
}
