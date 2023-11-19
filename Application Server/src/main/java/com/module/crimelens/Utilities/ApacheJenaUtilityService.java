package com.module.crimelens.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.springframework.stereotype.Service;

@Service
public class ApacheJenaUtilityService {
    
    public <T> List<T> getQueryResult(String query, String endpoint, Function<QuerySolution, T> mapper) {
        try {
            QueryExecution qe = QueryExecutionFactory.sparqlService(endpoint, query);
            ResultSet results = qe.execSelect();

            List<T> resultList = new ArrayList<>();

            while (results.hasNext()) {
                QuerySolution querySolution = results.nextSolution();
                resultList.add(mapper.apply(querySolution));
            }

            qe.close();
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; 
    }
}
