package com.module.crimelens.Repositories;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.module.crimelens.Models.CrimeEvent;
import com.module.crimelens.Utilities.ApacheJenaUtilityService;
import com.module.crimelens.Utilities.CrimeLensUtilityService;
import com.module.crimelens.Utilities.SparqlQueryUtility;

@Repository
public class CrimeEventRepository {

    private String endpoint = "http://datastore:3030/ds";

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
                "cl:hasCrimeID", "CrimeID",
                "cl:hasClassification", "Classification",
                "cl:hasCrimeDate", "CrimeDate",
                "cl:hasLocationID", "Location",
                "cl:hasVictimID", "Victim",
                "cl:hasPerpetratorID", "Perpetrator");
    }

    public List<CrimeEvent> findAll(Integer fromYear, Integer limit) {
        
        List<String> bindings = null;
        List<String> filterClauses = null;
        if (fromYear != null) {
                bindings = Arrays.asList("year(?CrimeDate) AS ?year");
                filterClauses = Arrays.asList("?year >= " + fromYear);
        }
            
            String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, bindings, filterClauses, limit == null ? 50 : limit);
    
            List<CrimeEvent> crimeEvents = apacheJenaUtilityService
                    .<CrimeEvent>getQueryResult(query, endpoint, CrimeLensUtilityService::mapToCrimeEvent);
    
            return crimeEvents;
    }

    public CrimeEvent findById(Integer id) {
        
        List<String> filterClauses = null;
        // ?CrimeID = toString(id)
        filterClauses = Arrays.asList("?CrimeID = " + id.toString());

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, null, filterClauses, 1);

        List<CrimeEvent> crimeEvents = apacheJenaUtilityService
                .<CrimeEvent>getQueryResult(query, endpoint, CrimeLensUtilityService::mapToCrimeEvent);

        return crimeEvents.isEmpty() ? null : crimeEvents.get(0);
    }

    public List<CrimeEvent> findByClassification(String classification) {
        
        List<String> filterClauses = null;
        // ?Classification = classification
        filterClauses = Arrays.asList("?Classification = \"" + classification + "\"");

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, null, filterClauses, 50);

        List<CrimeEvent> crimeEvents = apacheJenaUtilityService
                .<CrimeEvent>getQueryResult(query, endpoint, CrimeLensUtilityService::mapToCrimeEvent);

        return crimeEvents;
    }

    public List<CrimeEvent> findByLocation(Integer locationId) {
        
        List<String> filterClauses = null;
        // ?Location = locationId
        filterClauses = Arrays.asList("?Location = " + locationId.toString());

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, null, filterClauses, 50);

        List<CrimeEvent> crimeEvents = apacheJenaUtilityService
                .<CrimeEvent>getQueryResult(query, endpoint, CrimeLensUtilityService::mapToCrimeEvent);

        return crimeEvents;
    }

    public List<CrimeEvent> findByDate(String date) {
        
        List<String> filterClauses = null;
        // ?CrimeDate = date
        filterClauses = Arrays.asList("?CrimeDate = \"" + date + "\"^^xsd:date");

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, null, filterClauses, 50);

        List<CrimeEvent> crimeEvents = apacheJenaUtilityService
                .<CrimeEvent>getQueryResult(query, endpoint, CrimeLensUtilityService::mapToCrimeEvent);

        return crimeEvents;
    }

    public List<CrimeEvent> findByVictim(Integer victimId) {
        
        List<String> filterClauses = null;
        // ?Victim = victimId
        filterClauses = Arrays.asList("?Victim = " + victimId.toString());

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, null, filterClauses, 50);

        List<CrimeEvent> crimeEvents = apacheJenaUtilityService
                .<CrimeEvent>getQueryResult(query, endpoint, CrimeLensUtilityService::mapToCrimeEvent);

        return crimeEvents;
    }

    public List<CrimeEvent> findByPerpetrator(Integer perpetratorId) {
        
        List<String> filterClauses = null;
        // ?Perpetrator = perpetratorId
        filterClauses = Arrays.asList("?Perpetrator = " + perpetratorId.toString());

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, null, filterClauses, 50);

        List<CrimeEvent> crimeEvents = apacheJenaUtilityService
                .<CrimeEvent>getQueryResult(query, endpoint, CrimeLensUtilityService::mapToCrimeEvent);

        return crimeEvents;
    }

    public CrimeEvent saveOrUpdate(CrimeEvent crimeEvent) {
        return null;
    }

    public CrimeEvent deleteById(Integer id) {
        return null;
    }
}
