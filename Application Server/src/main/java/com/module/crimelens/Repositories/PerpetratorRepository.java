package com.module.crimelens.Repositories;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.module.crimelens.Models.Perpetrator;
import com.module.crimelens.Utilities.ApacheJenaUtilityService;
import com.module.crimelens.Utilities.CrimeLensUtilityService;
import com.module.crimelens.Utilities.SparqlQueryUtility;

@Repository
public class PerpetratorRepository {

    private String endpoint = "http://localhost:3030/ds";

    @Autowired
    private ApacheJenaUtilityService apacheJenaUtilityService;

    private static List<String> selectVariables;
    private static String entity;
    private static Map<String, String> whereClauses;

    static {
        selectVariables = Arrays.asList("Perpetrator", "PerpetratorID", "Race", "Age", "Gender");
        entity = "Perpetrator";

        whereClauses = Map.of(
            "cl:hasPerpetratorID", "PerpetratorID",
            "dbp:Race_\\(human_categorization\\)", "Race",
            "foaf:age", "Age",
            "foaf:gender", "Gender"
        );
    }
    
    public List<Perpetrator> findAll(Integer limit) {
        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, null, null, limit == null ? 50 : limit);

        List<Perpetrator> perpetrators = apacheJenaUtilityService.<Perpetrator>getQueryResult(query, endpoint, CrimeLensUtilityService::mapToPerpetrator);

        return perpetrators;
    }

    public Perpetrator findById(Integer id) {
        List<String> filterClauses = null;
        // ?PerpetratorID = id
        filterClauses = Arrays.asList("?PerpetratorID = " + id.toString());

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, null, filterClauses, 1);

        List<Perpetrator> perpetrators = apacheJenaUtilityService.<Perpetrator>getQueryResult(query, endpoint, CrimeLensUtilityService::mapToPerpetrator);

        return perpetrators.isEmpty() ? null : perpetrators.get(0);
    }

    public List<Perpetrator> findByAge(Integer age) {
        List<String> filterClauses = null;
        // ?Age = age
        filterClauses = Arrays.asList("?Age = " + age.toString());

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, null, filterClauses, null);

        List<Perpetrator> perpetrators = apacheJenaUtilityService.<Perpetrator>getQueryResult(query, endpoint, CrimeLensUtilityService::mapToPerpetrator);

        return perpetrators;
    }

    public List<Perpetrator> findByRace(String race) {
        List<String> filterClauses = null;
        filterClauses = Arrays.asList("?Race = " + race);

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, null, filterClauses, null);

        List<Perpetrator> perpetrators = apacheJenaUtilityService.<Perpetrator>getQueryResult(query, endpoint, CrimeLensUtilityService::mapToPerpetrator);

        return perpetrators;
    }

    public List<Perpetrator> findByGender(String gender) {
        List<String> filterClauses = null;
        filterClauses = Arrays.asList("?Gender = " + gender);

        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, null, filterClauses, null);

        List<Perpetrator> perpetrators = apacheJenaUtilityService.<Perpetrator>getQueryResult(query, endpoint, CrimeLensUtilityService::mapToPerpetrator);

        return perpetrators;
    }

    public Perpetrator saveOrUpdate(Perpetrator perpetrator) {
        return null;
    }

    public Perpetrator deleteById(Integer id) {
        return null;
    }
}