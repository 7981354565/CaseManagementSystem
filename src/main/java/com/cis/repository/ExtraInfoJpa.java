package com.cis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cis.entity.ExtraInfo;

public interface ExtraInfoJpa extends JpaRepository<ExtraInfo, Long> {

}
