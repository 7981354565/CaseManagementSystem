package com.cis.dto;

import java.time.LocalDate;

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
public class CaseDetailsDto {
	private Long id;
	private String causeOfAction;
	private String prayer;
	private String suitValuation;
	private Boolean hideParties;
	private Boolean plaintInLocallang;
	private LocalDate dateOfCauseOfAction;
	private String subject;
	private String reliefClaimed;
	private Double amount;
	private String state;
	private String district;
	private String taluka;
	private String village;
}
