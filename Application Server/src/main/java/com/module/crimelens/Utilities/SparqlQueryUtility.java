package com.module.crimelens.Utilities;

import java.util.List;
import java.util.Map;

public class SparqlQueryUtility {

    private static final String PREFIX = "PREFIX cl: <http://www.semanticweb.org/ontologies/2023/11/CrimeLens#>\n" + 
            "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
            "PREFIX dbp: <http://dbpedia.org/resource/>\n" +
            "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n";

    private static final String ns = "cl:";
    
    public static String findAll(String entity) {
        return "SELECT ?s ?p ?o WHERE { ?s a :" + entity + " . ?s ?p ?o . }";
    }

    public static String buildQuery(List<String> selectVariables, String entity, Map<String, String> whereClauses, List<String> bindings, List<String> filterClauses, Integer limit) {
        StringBuilder query = new StringBuilder(PREFIX);

        // SELECT Variables
        query.append("SELECT ");

        for (String selectVariable : selectVariables) {
            query.append("?").append(selectVariable).append(" ");
        }

        // WHERE Clauses
        query.append("\nWHERE {\n ?").append(entity).append(" a cl:").append(entity).append(" " + (whereClauses.isEmpty() ? ".\n" : ";\n"));

        int i = 0;
        for (Map.Entry<String, String> whereClause : whereClauses.entrySet()) {
            query.append(" ").append(whereClause.getKey()).append(" ?").append(whereClause.getValue()).append((i == whereClauses.size() - 1 ? ".\n" : ";\n"));
        }

        // BINDINGS
        if (bindings != null && !bindings.isEmpty()) {
            for (String bind : bindings) {
                query.append("BIND (").append(bind).append(")\n");
            }
        }

        // FILTER Clauses
        if (filterClauses != null && !filterClauses.isEmpty()) {
            for (String filterClause : filterClauses) {
                query.append("FILTER (").append(filterClause).append(")\n");
            }
        }

        query.append("}");

        // LIMIT
        if (limit != null) {
            query.append("\nLIMIT ").append(limit);
        }
        
        return query.toString();
    }

    public static String buildQuery(List<String> selectVariables, String entity, List<String> whereClauses, List<String> bindings, List<String> filterClauses, Integer limit) {
        StringBuilder query = new StringBuilder(PREFIX);

        // SELECT Variables
        query.append("SELECT ");

        for (String selectVariable : selectVariables) {
            query.append("?").append(selectVariable).append(" ");
        }

        // WHERE Clauses
        query.append("\nWHERE {\n ?").append(entity).append(" a cl:").append(entity).append(" " + (whereClauses.isEmpty() ? ".\n" : ";\n"));

        int i = 0;
        for (String whereClause : whereClauses) {
            query.append(" ").append(whereClause).append("\n");
        }

        // BINDINGS
        if (bindings != null && !bindings.isEmpty()) {
            for (String bind : bindings) {
                query.append("BIND (").append(bind).append(")\n");
            }
        }

        // FILTER Clauses
        if (filterClauses != null && !filterClauses.isEmpty()) {
            for (String filterClause : filterClauses) {
                query.append("FILTER (").append(filterClause).append(")\n");
            }
        }

        query.append("}");

        // LIMIT
        if (limit != null) {
            query.append("\nLIMIT ").append(limit);
        }
        
        return query.toString();
    }
}
