package com.module.crimelens.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Victim extends Person {
    
    private CrimeEvent crimeEvent;
}
