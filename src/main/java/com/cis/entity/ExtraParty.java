package com.cis.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class ExtraParty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private String complainant; //complainantOrAccused;
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
	private Boolean orgDetails;
	private String orgName;
}
