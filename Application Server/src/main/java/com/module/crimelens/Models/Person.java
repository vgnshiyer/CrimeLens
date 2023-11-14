package com.module.crimelens.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Person {
    
    private Integer id;

    private Integer age;

    private String race;

    private String gender;

    private CrimeEvent crimeEvent;
}
