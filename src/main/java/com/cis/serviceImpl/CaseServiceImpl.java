package com.cis.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cis.dto.ApiResponse;
import com.cis.entity.LegacyData;
import com.cis.entity.Petitioner;
import com.cis.entity.Respondent;
import com.cis.repository.LegacyDataRepo;
import com.cis.service.CaseService;

import jakarta.transaction.Transactional;

@Service
public class CaseServiceImpl implements CaseService {

	@Autowired
	private LegacyDataRepo legacyDataRepo;
	
	@Override
	@Transactional
	public ApiResponse saveCase(LegacyData legacyData) {
		 for (Petitioner petitioner : legacyData.getPetitioners()) {
	            petitioner.setLegacyData(legacyData);
	        }
	        for (Respondent respondent : legacyData.getRespondents()) {
	            respondent.setLegacyData(legacyData);
	        }
	        legacyDataRepo.save(legacyData);
	        return new ApiResponse("case registration successfully done",HttpStatus.OK);
	    }

}
