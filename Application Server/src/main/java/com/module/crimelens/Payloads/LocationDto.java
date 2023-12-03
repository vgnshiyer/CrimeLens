package com.module.crimelens.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationDto {
    
    private Double lat;

    private Double lon;

    private String street;

    private String city;

    private String state;
}
