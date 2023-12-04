package com.module.crimelens.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CrimeEventDto {
    
    private Integer id;

    private String classification;

    private String crimeDate;

    private Double lat;

    private Double lon;

    private String city;
    
    private String state;
    
    private String street;

}
