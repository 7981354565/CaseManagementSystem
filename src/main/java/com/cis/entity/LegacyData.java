package com.cis.entity;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LegacyData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "legacyData", cascade = CascadeType.ALL)
    private List<Petitioner> petitioners = new ArrayList<>();

    @OneToMany(mappedBy = "legacyData", cascade = CascadeType.ALL)
    private List<Respondent> respondents = new ArrayList<>();
	

//	@JsonIgnore
//	@ToString.Exclude
//	@OneToMany(targetEntity = Petitioner.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "legacy_id", referencedColumnName = "id")
//	private List<Petitioner> petitioner = new ArrayList<Petitioner>();
//	
//	@JsonIgnore
//	@ToString.Exclude
//	@OneToMany(targetEntity = Respondent.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "legacy_id", referencedColumnName = "id")
//	private List<Respondent> respondent = new ArrayList<Respondent>(); 
}
