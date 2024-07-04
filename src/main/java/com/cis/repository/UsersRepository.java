package com.cis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cis.entity.UsersEntity;

public interface UsersRepository extends JpaRepository<UsersEntity, Long>{

	Optional<UsersEntity> findByUserName(String ph);
	
}
