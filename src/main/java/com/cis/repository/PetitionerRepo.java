package com.cis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cis.entity.Petitioner;

public interface PetitionerRepo extends JpaRepository<Petitioner, Long> {

}
