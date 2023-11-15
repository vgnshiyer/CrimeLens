package com.module.crimelens.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.module.crimelens.Models.CrimeEvent;
import com.module.crimelens.Models.Location;
import com.module.crimelens.Models.Perpetrator;
import com.module.crimelens.Models.Victim;

@Service
public class CrimeEventService {
    
    public List<CrimeEvent> getAllCrimeEvents() {
        return null;
    }

    public CrimeEvent getCrimeEventById(Integer id) {
        return null;
    }

    public List<CrimeEvent> getCrimeEventsByClassification(String classification) {
        return null;
    }

    public List<CrimeEvent> getCrimeEventsByLocation(Location location) {
        return null;
    }

    public List<CrimeEvent> getCrimeEventsByVictim(Victim victim) {
        return null;
    }

    public List<CrimeEvent> getCrimeEventsByPerpetrator(Perpetrator perpetrator) {
        return null;
    }

    public List<Victim> getVictimsByCrimeEvent(Integer id) {
        return null;
    }

    public List<Perpetrator> getPerpetratorsByCrimeEvent(Integer id) {
        return null;
    }

    public CrimeEvent createCrimeEvent(CrimeEvent crimeEvent) {
        return null;
    }

    public CrimeEvent updateCrimeEvent(CrimeEvent crimeEvent) {
        return null;
    }

    public CrimeEvent deleteCrimeEvent(Integer id) {
        return null;
    }
}
