package com.cis.dto;

import java.sql.Time;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LegacyDataDto {
	
	private Long id;
	private String caseType;
	private String caseNo;
	private Integer year;
	private String srNo;
	private String year1;
	private String courtNo;
	private String natureCode;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfFiling;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfRegistration;
	private Time timeOfFiling;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfHearing;
	private String purposeOfListing;
	private String subPurpose;
	

}