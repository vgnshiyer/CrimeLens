package com.module.crimelens.Models;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CrimeEvent {

    private Integer id;

    private String classification;

    private String crimeDate;

    private Integer locationId;

    private Integer victimId;

    private Integer perpetratorId;

    private String description;
}
