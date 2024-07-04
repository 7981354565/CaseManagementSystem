package com.cis.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Petitioner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String complainant;
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
	private Boolean  orgDetails;
	private String orgName;

    @ManyToOne
    @JoinColumn(name = "legacy_id")
    private LegacyData legacyData;
	
//	@JsonIgnore
//	@ToString.Exclude
//	@ManyToOne(targetEntity = LegacyData.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//	@JoinColumn(name = "legacy_id", referencedColumnName = "id")
//	private LegacyData legacyData;
//
//	@JsonIgnore
//	@ToString.Exclude
//	@OneToMany(targetEntity = ExtraParty.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "extra_petitioner_id", referencedColumnName = "id")
//	private List<ExtraParty> extraParty;
	
}
