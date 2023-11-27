package com.module.crimelens.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.crimelens.Models.Perpetrator;
import com.module.crimelens.Repositories.PerpetratorRepository;

@Service
public class PerpetratorService {

    @Autowired
    private PerpetratorRepository perpetratorRepository;
    
    public List<Perpetrator> getAllPerpetrators(Integer limit) {
        return this.perpetratorRepository.findAll(limit);
    }

    public Perpetrator getPerpetratorById(Integer id) {
        return this.perpetratorRepository.findById(id);
    }

    public List<Perpetrator> getPerpetratorsByAge(Integer age) {
        return this.perpetratorRepository.findByAge(age);
    }

    public List<Perpetrator> getPerpetratorByRace(String race) {
        return this.perpetratorRepository.findByRace(race);
    }

    public List<Perpetrator> getPerpetratorByGender(String gender) {
        return this.perpetratorRepository.findByGender(gender);
    }

    public Perpetrator createPerpetrator(Perpetrator perpetrator) {
        return null;
    }

    public Perpetrator updatePerpetrator(Perpetrator perpetrator) {
        return null;
    }

    public Perpetrator deletePerpetrator(Integer id) {
        return null;
    }
}