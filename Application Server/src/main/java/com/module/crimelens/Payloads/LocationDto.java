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
}
