package com.module.crimelens.Repositories;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.module.crimelens.Models.Victim;
import com.module.crimelens.Utilities.ApacheJenaUtilityService;
import com.module.crimelens.Utilities.CrimeLensUtilityService;
import com.module.crimelens.Utilities.SparqlQueryUtility;

@Repository
public class VictimRepository {

    private String endpoint = "http://localhost:3030/ds";

    @Autowired
    private ApacheJenaUtilityService apacheJenaUtilityService;

    private static List<String> selectVariables;
    private static String entity;
    private static Map<String, String> whereClauses;

    static {
        selectVariables = Arrays.asList("Victim", "VictimID", "Race", "Age", "Gender");
        entity = "Victim";

        whereClauses = Map.of(
            "cl:hasVictimID", "VictimID",
            "dbp:Race_\\(human_categorization\\)", "Race",
            "foaf:age", "Age",
            "foaf:gender", "Gender"
        );
    }
    
    public List<Victim> findAll(Integer limit) {
        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, null, limit == null ? 50 : limit);

        List<Victim> victims = apacheJenaUtilityService.<Victim>getQueryResult(query, endpoint, CrimeLensUtilityService::mapToVictim);

        return victims;
    }

    public Victim findById(Integer id) {
        Map<String, String> filterClauses = Map.of("VictimID", id.toString());

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, filterClauses, 1);

        List<Victim> victims = apacheJenaUtilityService.<Victim>getQueryResult(query, endpoint, CrimeLensUtilityService::mapToVictim);

        return victims.isEmpty() ? null : victims.get(0);
    }

    public List<Victim> findByAge(Integer age) {
        Map<String, String> filterClauses = Map.of("Age", age.toString());

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, filterClauses, null);

        List<Victim> victims = apacheJenaUtilityService.<Victim>getQueryResult(query, endpoint, CrimeLensUtilityService::mapToVictim);

        return victims;
    }

    public List<Victim> findByRace(String race) {
        Map<String, String> filterClauses = Map.of("Race", "\"" + race + "\"^^xsd:string");

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, filterClauses, null);

        List<Victim> victims = apacheJenaUtilityService.<Victim>getQueryResult(query, endpoint, CrimeLensUtilityService::mapToVictim);

        return victims;
    }

    public List<Victim> findByGender(String gender) {
        Map<String, String> filterClauses = Map.of("Gender", "\"" + gender + "\"^^xsd:string");

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, filterClauses, null);

        List<Victim> victims = apacheJenaUtilityService.<Victim>getQueryResult(query, endpoint, CrimeLensUtilityService::mapToVictim);

        return victims;
    }

    public Victim saveOrUpdate(Victim victim) {
        return null;
    }

    public Victim deleteById(Integer id) {
        return null;
    }
}