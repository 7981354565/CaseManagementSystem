package com.cis.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity
public class CaseDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
