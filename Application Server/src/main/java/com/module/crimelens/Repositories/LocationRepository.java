package com.module.crimelens.Repositories;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.module.crimelens.Models.Location;
import com.module.crimelens.Utilities.ApacheJenaUtilityService;
import com.module.crimelens.Utilities.CrimeLensUtilityService;
import com.module.crimelens.Utilities.SparqlQueryUtility;

@Repository
public class LocationRepository {
    
    private String endpoint = "http://datastore:3030/ds";

    @Autowired
    private ApacheJenaUtilityService apacheJenaUtilityService;

    private static List<String> selectVariables;
    private static String entity;
    private static Map<String, String> whereClauses;
    
    static {
        selectVariables = Arrays.asList("Location", "Latitude", "Longitude", "City", "LocationID", "State", "Street");

        entity = "Location";

        whereClauses = Map.of(
                "dbp:Latitude", "Latitude",
                "dbp:Longitude", "Longitude",
                "cl:hasCity", "City",
                "cl:hasLocationID", "LocationID",
                "cl:hasState", "State",
                "cl:hasStreet", "Street");

    }

    public Location findById(Integer id) {
        
        List<String> filterClauses = null;
        if (id != null) {
            filterClauses = Arrays.asList("?LocationID = " + id);
        }
        
        String query = SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, null, filterClauses, null);

        List<Location> locations = apacheJenaUtilityService
                .<Location>getQueryResult(query, endpoint, CrimeLensUtilityService::mapToLocation);

        return locations.isEmpty() ? null : locations.get(0);
    }
}
