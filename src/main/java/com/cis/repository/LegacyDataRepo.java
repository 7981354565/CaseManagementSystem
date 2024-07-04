package com.cis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cis.entity.LegacyData;

public interface LegacyDataRepo extends JpaRepository<LegacyData, Long>{

}
