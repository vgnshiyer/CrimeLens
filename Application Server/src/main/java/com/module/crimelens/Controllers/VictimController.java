package com.module.crimelens.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.module.crimelens.Models.Victim;
import com.module.crimelens.Services.VictimService;

@CrossOrigin
@RestController
@RequestMapping("/api/victim")
public class VictimController {

    @Autowired
    private VictimService victimService;

    @GetMapping("/")
    public ResponseEntity<List<Victim>> getAllVictims(
            @RequestParam(required = false) Integer limit) {
        return ResponseEntity.ok(this.victimService.getAllVictims(limit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Victim> getVictimById(Integer id) {
        return ResponseEntity.ok(this.victimService.getVictimById(id));
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<List<Victim>> getVictimsByAge(Integer age) {
        return ResponseEntity.ok(this.victimService.getVictimsByAge(age));
    }

    @GetMapping("/race/{race}")
    public ResponseEntity<List<Victim>> getVictimsByRace(String race) {
        return ResponseEntity.ok(this.victimService.getVictimByRace(race));
    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<Victim>> getVictimsByGender(String gender) {
        return ResponseEntity.ok(this.victimService.getVictimByGender(gender));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Victim> updateVictimById(Integer id, Victim victim) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/")
    public ResponseEntity<Victim> createVictim(Victim victim) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVictimById(Integer id) {
        return ResponseEntity.ok().build();
    }
}