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

import com.module.crimelens.Models.Perpetrator;
import com.module.crimelens.Services.PerpetratorService;

@CrossOrigin
@RestController
@RequestMapping("/api/perpetrator")
public class PerpetratorController {

    @Autowired
    private PerpetratorService perpetratorService;

    @GetMapping("/")
    public ResponseEntity<List<Perpetrator>> getAllPerpetrators(
            @RequestParam(required = false) Integer limit) {
        return ResponseEntity.ok(this.perpetratorService.getAllPerpetrators(limit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perpetrator> getPerpetratorById(Integer id) {
        return ResponseEntity.ok(this.perpetratorService.getPerpetratorById(id));
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<List<Perpetrator>> getPerpetratorsByAge(Integer age) {
        return ResponseEntity.ok(this.perpetratorService.getPerpetratorsByAge(age));
    }

    @GetMapping("/race/{race}")
    public ResponseEntity<List<Perpetrator>> getPerpetratorsByRace(String race) {
        return ResponseEntity.ok(this.perpetratorService.getPerpetratorByRace(race));
    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<Perpetrator>> getPerpetratorsByGender(String gender) {
        return ResponseEntity.ok(this.perpetratorService.getPerpetratorByGender(gender));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perpetrator> updatePerpetratorById(Integer id, Perpetrator perpetrator) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/")
    public ResponseEntity<Perpetrator> createPerpetrator(Perpetrator perpetrator) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerpetratorById(Integer id) {
        return ResponseEntity.ok().build();
    }
}