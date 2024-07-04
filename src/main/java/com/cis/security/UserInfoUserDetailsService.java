package com.cis.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cis.entity.UsersEntity;
import com.cis.repository.UsersRepository;



@Component
public class UserInfoUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsersRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsersEntity> userEntity = userRepo.findByUserName(username);

		return userEntity.map(UserInfoUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User Not found" + username));

		
	}
	
}
