package com.module.crimelens.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Location {

    private Integer id;
    
    private String state;

    private String city;

    private String street;

    private Double lat;

    private Double lon;
}
