package com.cis.dto;

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
public class PartyWiseActsDto {
private Long id;
private String petitionerOrAccusedName;
private String act1;
private String ActSection1;
}
