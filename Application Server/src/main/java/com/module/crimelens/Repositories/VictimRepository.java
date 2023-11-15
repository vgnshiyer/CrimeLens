package com.module.crimelens.Repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.module.crimelens.Models.Victim;

@Repository
public class VictimRepository {
    
    public List<Victim> findAll() {
        return null;
    }

    public Victim findById(Integer id) {
        return null;
    }

    public List<Victim> findByAge(Integer age) {
        return null;
    }

    public List<Victim> findByRace(String race) {
        return null;
    }

    public List<Victim> findByGender(String gender) {
        return null;
    }

    public Victim saveOrUpdate(Victim victim) {
        return null;
    }

    public Victim deleteById(Integer id) {
        return null;
    }
}
