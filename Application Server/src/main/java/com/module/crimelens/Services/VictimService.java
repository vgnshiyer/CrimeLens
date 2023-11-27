package com.module.crimelens.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.crimelens.Models.Victim;
import com.module.crimelens.Repositories.VictimRepository;

@Service
public class VictimService {

    @Autowired
    private VictimRepository victimRepository;
    
    public List<Victim> getAllVictims(Integer limit) {
        return this.victimRepository.findAll(limit);
    }

    public Victim getVictimById(Integer id) {
        return this.victimRepository.findById(id);
    }

    public List<Victim> getVictimsByAge(Integer age) {
        return this.victimRepository.findByAge(age);
    }

    public List<Victim> getVictimByRace(String race) {
        return this.victimRepository.findByRace(race);
    }

    public List<Victim> getVictimByGender(String gender) {
        return this.victimRepository.findByGender(gender);
    }

    public Victim createVictim(Victim victim) {
        return null;
    }

    public Victim updateVictim(Victim victim) {
        return null;
    }

    public Victim deleteVictim(Integer id) {
        return null;
    }
}
