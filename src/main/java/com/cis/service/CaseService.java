package com.cis.service;

import com.cis.dto.ApiResponse;
import com.cis.dto.LegacyDataDto;
import com.cis.entity.LegacyData;

public interface CaseService {

	ApiResponse saveCase(LegacyData legacyDataDto);
	
}
