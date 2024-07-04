package com.cis.dto;

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
public class RespondentDto {
	private Long id;
	private String accused;
	private String relation;
	private Integer age;
	private Boolean differentlyAbled;
	private String caste;
	private Boolean inPerson;
	private String nameOfAdvocate;
	private String email;
	private String address;
	private String state;
	private String town;
	private String taluka;
	private String policeStationCode;
	private String gender;
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dob;
	private Integer extraRespondent;
	private Boolean proformaRespondent;
	private String barRegNo;
	private Long mobileNo;
	private Integer pincode;
	private String district;
	private String ward;
	private String village;
	private String uidNo;
	private String orgName;
	private Boolean  orgDetails;
	
	

}
