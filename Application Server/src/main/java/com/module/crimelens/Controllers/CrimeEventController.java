package com.module.crimelens.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.module.crimelens.Models.CrimeEvent;
import com.module.crimelens.Models.Perpetrator;
import com.module.crimelens.Models.Victim;
import com.module.crimelens.Services.CrimeEventService;

@RestController
@RequestMapping("/api/crime")
public class CrimeEventController {

    @Autowired
    private CrimeEventService crimeEventService;

    @GetMapping("/")
    public ResponseEntity<List<CrimeEvent>> getAllCrimeEvents(
            @RequestParam(required = false) Integer limit) {
        return new ResponseEntity<> (this.crimeEventService.getAllCrimeEvents(limit), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CrimeEvent> getCrimeEventById(@PathVariable Integer id) {
        return new ResponseEntity<> (this.crimeEventService.getCrimeEventById(id), HttpStatus.OK);
    }

    @GetMapping("/location/{locationId}")
    public ResponseEntity<List<CrimeEvent>> getCrimeEventsByLocation(@PathVariable Integer locationId) {
        return new ResponseEntity<> (this.crimeEventService.getCrimeEventsByLocation(locationId), HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<CrimeEvent>> getCrimeEventsByDate(@PathVariable String date) {
        return new ResponseEntity<> (this.crimeEventService.getCrimeEventsByDate(date), HttpStatus.OK);
    }

    @GetMapping("/victim/{victimId}")
    public ResponseEntity<List<CrimeEvent>> getCrimeEventsByVictim(@PathVariable Integer victimId) {
        return new ResponseEntity<> (this.crimeEventService.getCrimeEventsByVictim(victimId), HttpStatus.OK);
    }

    @GetMapping("/perpetrator/{perpetratorId}")
    public ResponseEntity<List<CrimeEvent>> getCrimeEventsByPerpetrator(@PathVariable Integer perpetratorId) {
        return new ResponseEntity<> (this.crimeEventService.getCrimeEventsByPerpetrator(perpetratorId), HttpStatus.OK);
    }

    @GetMapping("/classification/{classification}")
    public ResponseEntity<List<CrimeEvent>> getCrimeEventsByClassification(@PathVariable String classification) {
        return new ResponseEntity<> (this.crimeEventService.getCrimeEventsByClassification(classification), HttpStatus.OK);
    }

    @GetMapping("/{id}/victims")
    public ResponseEntity<List<Victim>> getVictimsByCrimeEvent(@PathVariable Integer id) {
        return new ResponseEntity<> (this.crimeEventService.getVictimsByCrimeEvent(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/perpetrators")
    public ResponseEntity<List<Perpetrator>> getPerpetratorsByCrimeEvent(@PathVariable Integer id) {
        return new ResponseEntity<> (this.crimeEventService.getPerpetratorsByCrimeEvent(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public CrimeEvent createCrimeEvent(CrimeEvent crimeEvent) {
        return null;
    }

    @PutMapping("/{id}")
    public CrimeEvent updateCrimeEvent(@PathVariable Integer id, CrimeEvent crimeEvent) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCrimeEvent(@PathVariable Integer id) {
        return;
    }
}
