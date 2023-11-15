package com.module.crimelens.Repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.module.crimelens.Models.CrimeEvent;

@Repository
public class CrimeEventRepository {
    
    public List<CrimeEvent> findAll() {
        return null;
    }

    public CrimeEvent findById(Integer id) {
        return null;
    }

    public List<CrimeEvent> findByClassification(String classification) {
        return null;
    }

    public List<CrimeEvent> findByLocation(Integer locationId) {
        return null;
    }

    public List<CrimeEvent> findByVictim(Integer victimId) {
        return null;
    }

    public List<CrimeEvent> findByPerpetrator(Integer perpetratorId) {
        return null;
    }

    public CrimeEvent saveOrUpdate(CrimeEvent crimeEvent) {
        return null;
    }

    public CrimeEvent deleteById(Integer id) {
        return null;
    }
}
