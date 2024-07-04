package com.cis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cis.entity.CaseDetails;

public interface CaseDetailsRepo extends JpaRepository<CaseDetails, Long>{

}
