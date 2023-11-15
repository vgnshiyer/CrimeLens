package com.module.crimelens.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.module.crimelens.Models.Perpetrator;

@RestController
@RequestMapping("/api/perpetrator")
public class PerpetratorController {

    @GetMapping("/")
    public List<Perpetrator> getAllPerpetrators(
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String race,
            @RequestParam(required = false) String gender) {
        return null;
    }

    @GetMapping("/{id}")
    public Perpetrator getPerpetratorById(Integer id) {
        return null;
    }

    @PutMapping("/{id}")
    public Perpetrator updatePerpetratorById(Integer id, Perpetrator perpetrator) {
        return null;
    }

    @PostMapping("/")
    public Perpetrator createPerpetrator(Perpetrator perpetrator) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePerpetratorById(Integer id) {
        return;
    }
}