package com.module.crimelens.Controllers;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.module.crimelens.Models.CrimeEvent;
import com.module.crimelens.Models.Location;
import com.module.crimelens.Models.Perpetrator;
import com.module.crimelens.Models.Victim;

@RestController
@RequestMapping("/api/crime")
public class CrimeEventController {

    @GetMapping("/")
    public List<CrimeEvent> getAllCrimeEvents(
            @RequestParam(required = false) String classification,
            @RequestParam(required = false) Date date) {
        return null;
    }

    @GetMapping("/{id}")
    public CrimeEvent getCrimeEventById(@PathVariable Integer id) {
        return null;
    }

    @GetMapping("/classification")
    public List<CrimeEvent> getCrimeEventsByClassification(@RequestParam String classification) {
        return null;
    }

    @GetMapping("/location/{location}")
    public List<CrimeEvent> getCrimeEventsByLocation(@PathVariable Location location) {
        return null;
    }

    @GetMapping("/victim/{victim}")
    public List<CrimeEvent> getCrimeEventsByVictim(@PathVariable Victim victim) {
        return null;
    }

    @GetMapping("/perpetrator/{perpetrator}")
    public List<CrimeEvent> getCrimeEventsByPerpetrator(@PathVariable Perpetrator perpetrator) {
        return null;
    }

    @GetMapping("/{id}/victims")
    public List<Victim> getVictimsByCrimeEvent(@PathVariable Integer id) {
        return null;
    }

    @GetMapping("/{id}/perpetrators")
    public List<Victim> getPerpetratorsByCrimeEvent(@PathVariable Integer id) {
        return null;
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
