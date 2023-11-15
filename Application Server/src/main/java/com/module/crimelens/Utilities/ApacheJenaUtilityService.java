package com.module.crimelens.Utilities;

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

public class ApacheJenaUtilityService {
    
    public <T> List<T> getQueryResult(String query, String endpoint, Function<QuerySolution, T> mapper) {
        QueryExecution queryExecution = null;
        Query queryObject = null;
        List<T> result = null;

        try {
            queryObject = QueryFactory.create(query);
            queryExecution = QueryExecutionFactory.sparqlService(endpoint, queryObject);
            ResultSet resultSet = queryExecution.execSelect();
            result = ResultSetFormatter.toList(resultSet).stream().map(mapper).collect(Collectors.toList());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (queryExecution != null) {
                queryExecution.close();
            }
        }

        return result;
    }
}
