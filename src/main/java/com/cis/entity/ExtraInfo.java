package com.cis.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ExtraInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String passportNum;
	private String country;
	private String occupation;
	private String state;
	private String town;
	private String taluka;
	private String panNum;
	private String nationality;
	private String alternateAddress;
	private String district;
	private String ward;
	private String village;
	private String faxNum;
	private Long phoneNum;
}
