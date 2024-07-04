package com.cis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cis.entity.LawyerEntity;


@Repository
public interface LawyerRepository extends JpaRepository<LawyerEntity, Long> {

	 Optional<LawyerEntity> findByName(String fileName);
	    
	    @Query(value ="SELECT file_path FROM lawyer_table",nativeQuery = true)
	    List<String> getAllImageFilenames();
	
}
