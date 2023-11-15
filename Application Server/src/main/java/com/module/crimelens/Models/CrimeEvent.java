package com.module.crimelens.Models;

import java.util.Date;
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

    private Date crimeDate;

    private List<Victim> victims;

    private List<Perpetrator> perpetrators;

    private Location location;

    private String description;
}