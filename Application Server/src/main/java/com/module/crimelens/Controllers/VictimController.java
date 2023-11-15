package com.module.crimelens.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.module.crimelens.Models.Victim;

@RestController
@RequestMapping("/api/victim")
public class VictimController {

    @GetMapping("/")
    public List<Victim> getAllVictims(
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String race,
            @RequestParam(required = false) String gender) {
        return null;
    }

    @GetMapping("/{id}")
    public Victim getVictimById(Integer id) {
        return null;
    }

    @PutMapping("/{id}")
    public Victim updateVictimById(Integer id, Victim victim) {
        return null;
    }

    @PostMapping("/")
    public Victim createVictim(Victim victim) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteVictimById(Integer id) {
        return;
    }
}
