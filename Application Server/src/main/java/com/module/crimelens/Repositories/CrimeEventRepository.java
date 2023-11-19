package com.module.crimelens.Repositories;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.module.crimelens.Models.CrimeEvent;
import com.module.crimelens.Utilities.ApacheJenaUtilityService;
import com.module.crimelens.Utilities.SparqlQueryUtility;

import org.apache.jena.query.QuerySolution;

@Repository
public class CrimeEventRepository {

    private String endpoint = "http://localhost:3030/ds";

    @Autowired
    private ApacheJenaUtilityService apacheJenaUtilityService;

    private static List<String> selectVariables;
    private static String entity;
    private static Map<String, String> whereClauses;

    static {
        selectVariables = Arrays.asList("CrimeEvent", "CrimeID", "Classification", "CrimeDate", "Location",
                "Victim", "Perpetrator");

        entity = "CrimeEvent";

        whereClauses = Map.of(
                "hasCrimeID", "CrimeID",
                "hasClassification", "Classification",
                "hasCrimeDate", "CrimeDate",
                "hasLocationID", "Location",
                "hasVictimID", "Victim",
                "hasPerpetratorID", "Perpetrator");
    }

    public List<CrimeEvent> findAll() {
        return null;
    }

    public CrimeEvent findById(Integer id) {
        
        Map<String, String> filterClauses = new HashMap<>();
        filterClauses.put("CrimeID", id.toString());

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, filterClauses, 1);

        CrimeEvent crimeEvents = apacheJenaUtilityService
                .<CrimeEvent>getQueryResult(query, endpoint, (QuerySolution querySolution) -> {
                    CrimeEvent crimeEvent = new CrimeEvent();
                    crimeEvent.setId(querySolution.get("CrimeID").asLiteral().getInt());
                    crimeEvent.setClassification(querySolution.get("Classification").asLiteral().getString());
                    crimeEvent.setCrimeDate(querySolution.get("CrimeDate").asLiteral().getString());
                    crimeEvent.setLocationId(querySolution.get("Location").asLiteral().getInt());
                    crimeEvent.setVictimId(querySolution.get("Victim").asLiteral().getInt());
                    crimeEvent.setPerpetratorId(querySolution.get("Perpetrator").asLiteral().getInt());
                    return crimeEvent;
                }).get(0);

        return crimeEvents;
    }

    public List<CrimeEvent> findByClassification(String classification) {
        
        Map<String, String> filterClauses = Map.of(
                "Classification", "\"" + classification + "\"");

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, filterClauses, 50);

        List<CrimeEvent> crimeEvents = apacheJenaUtilityService
                .<CrimeEvent>getQueryResult(query, endpoint, (QuerySolution querySolution) -> {
                    CrimeEvent crimeEvent = new CrimeEvent();
                    crimeEvent.setId(querySolution.get("CrimeID").asLiteral().getInt());
                    crimeEvent.setClassification(querySolution.get("Classification").asLiteral().getString());
                    crimeEvent.setCrimeDate(querySolution.get("CrimeDate").asLiteral().getString());
                    crimeEvent.setLocationId(querySolution.get("Location").asLiteral().getInt());
                    crimeEvent.setVictimId(querySolution.get("Victim").asLiteral().getInt());
                    crimeEvent.setPerpetratorId(querySolution.get("Perpetrator").asLiteral().getInt());
                    return crimeEvent;
                });

        return crimeEvents;
    }

    public List<CrimeEvent> findByLocation(Integer locationId) {
        
        Map<String, String> filterClauses = Map.of(
                "Location", locationId.toString());

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, filterClauses, 50);

        List<CrimeEvent> crimeEvents = apacheJenaUtilityService
                .<CrimeEvent>getQueryResult(query, endpoint, (QuerySolution querySolution) -> {
                    CrimeEvent crimeEvent = new CrimeEvent();
                    crimeEvent.setId(querySolution.get("CrimeID").asLiteral().getInt());
                    crimeEvent.setClassification(querySolution.get("Classification").asLiteral().getString());
                    crimeEvent.setCrimeDate(querySolution.get("CrimeDate").asLiteral().getString());
                    crimeEvent.setLocationId(querySolution.get("Location").asLiteral().getInt());
                    crimeEvent.setVictimId(querySolution.get("Victim").asLiteral().getInt());
                    crimeEvent.setPerpetratorId(querySolution.get("Perpetrator").asLiteral().getInt());
                    return crimeEvent;
                });

        return crimeEvents;
    }

    public List<CrimeEvent> findByVictim(Integer victimId) {
        
        Map<String, String> filterClauses = Map.of(
                "Victim", victimId.toString());

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, filterClauses, 50);

        List<CrimeEvent> crimeEvents = apacheJenaUtilityService
                .<CrimeEvent>getQueryResult(query, endpoint, (QuerySolution querySolution) -> {
                    CrimeEvent crimeEvent = new CrimeEvent();
                    crimeEvent.setId(querySolution.get("CrimeID").asLiteral().getInt());
                    crimeEvent.setClassification(querySolution.get("Classification").asLiteral().getString());
                    crimeEvent.setCrimeDate(querySolution.get("CrimeDate").asLiteral().getString());
                    crimeEvent.setLocationId(querySolution.get("Location").asLiteral().getInt());
                    crimeEvent.setVictimId(querySolution.get("Victim").asLiteral().getInt());
                    crimeEvent.setPerpetratorId(querySolution.get("Perpetrator").asLiteral().getInt());
                    return crimeEvent;
                });

        return crimeEvents;
    }

    public List<CrimeEvent> findByPerpetrator(Integer perpetratorId) {
        
        Map<String, String> filterClauses = Map.of(
                "Perpetrator", perpetratorId.toString());

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, filterClauses, 50);

        List<CrimeEvent> crimeEvents = apacheJenaUtilityService
                .<CrimeEvent>getQueryResult(query, endpoint, (QuerySolution querySolution) -> {
                    CrimeEvent crimeEvent = new CrimeEvent();
                    crimeEvent.setId(querySolution.get("CrimeID").asLiteral().getInt());
                    crimeEvent.setClassification(querySolution.get("Classification").asLiteral().getString());
                    crimeEvent.setCrimeDate(querySolution.get("CrimeDate").asLiteral().getString());
                    crimeEvent.setLocationId(querySolution.get("Location").asLiteral().getInt());
                    crimeEvent.setVictimId(querySolution.get("Victim").asLiteral().getInt());
                    crimeEvent.setPerpetratorId(querySolution.get("Perpetrator").asLiteral().getInt());
                    return crimeEvent;
                });

        return crimeEvents;
    }

    public CrimeEvent saveOrUpdate(CrimeEvent crimeEvent) {
        return null;
    }

    public CrimeEvent deleteById(Integer id) {
        return null;
    }
}
