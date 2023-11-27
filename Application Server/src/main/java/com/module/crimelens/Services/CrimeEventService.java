package com.module.crimelens.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.crimelens.Models.CrimeEvent;
import com.module.crimelens.Models.Perpetrator;
import com.module.crimelens.Models.Victim;
import com.module.crimelens.Repositories.CrimeEventRepository;

@Service
public class CrimeEventService {

    @Autowired
    private CrimeEventRepository crimeEventRepository;

    @Autowired
    private VictimService victimService;

    @Autowired
    private PerpetratorService perpetratorService;
    
    public List<CrimeEvent> getAllCrimeEvents(Integer limit) {
        return this.crimeEventRepository.findAll(limit);
    }

    public CrimeEvent getCrimeEventById(Integer id) {
        return this.crimeEventRepository.findById(id);
    }

    public List<CrimeEvent> getCrimeEventsByClassification(String classification) {
        return this.crimeEventRepository.findByClassification(classification);
    }

    public List<CrimeEvent> getCrimeEventsByLocation(Integer locationId) {
        return this.crimeEventRepository.findByLocation(locationId);
    }

    public List<CrimeEvent> getCrimeEventsByDate(String date) {
        return this.crimeEventRepository.findByDate(date);
    }

    public List<CrimeEvent> getCrimeEventsByVictim(Integer victimId) {
        return this.crimeEventRepository.findByVictim(victimId);
    }

    public List<CrimeEvent> getCrimeEventsByPerpetrator(Integer perpetratorId) {
        return this.crimeEventRepository.findByPerpetrator(perpetratorId);
    }

    public List<Victim> getVictimsByCrimeEvent(Integer id) {
        
        CrimeEvent crimeEvent = this.crimeEventRepository.findById(id);

        Integer victimId = crimeEvent.getVictimId();

        List<Victim> victims = new ArrayList<Victim>();
        victims.add(this.victimService.getVictimById(victimId));

        return victims;
    }

    public List<Perpetrator> getPerpetratorsByCrimeEvent(Integer id) {
        
        CrimeEvent crimeEvent = this.crimeEventRepository.findById(id);

        Integer perpetratorId = crimeEvent.getPerpetratorId();

        List<Perpetrator> perpetrators = new ArrayList<Perpetrator>();
        perpetrators.add(this.perpetratorService.getPerpetratorById(perpetratorId));

        return perpetrators;
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
