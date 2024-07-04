package com.cis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cis.dto.ApiResponse;
import com.cis.entity.LegacyData;
import com.cis.service.CaseService;

@RestController
@RequestMapping("/case")
public class CaseController {

	@Autowired
	private CaseService caseService;
	
	@PostMapping("/caseSave")
	public ApiResponse saveUser(@RequestBody LegacyData legacyData) {
		return caseService.saveCase(legacyData);
	} 
	
}
