package com.module.crimelens.Repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.module.crimelens.Models.Perpetrator;

@Repository
public class PerpetratorRepository {
    
    public List<Perpetrator> findAll() {
        return null;
    }

    public Perpetrator findById(Integer id) {
        return null;
    }

    public List<Perpetrator> findByAge(Integer age) {
        return null;
    }

    public List<Perpetrator> findByRace(String race) {
        return null;
    }

    public List<Perpetrator> findByGender(String gender) {
        return null;
    }

    public Perpetrator saveOrUpdate(Perpetrator perpetrator) {
        return null;
    }

    public Perpetrator deleteById(Integer id) {
        return null;
    }
}