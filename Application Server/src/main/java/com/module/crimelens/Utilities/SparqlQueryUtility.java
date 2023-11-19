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

    public static String buildQuery(List<String> selectVariables, String entity, Map<String, String> whereClauses, Map<String, String> filterClauses, Integer limit) {
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
            query.append(" cl:").append(whereClause.getKey()).append(" ?").append(whereClause.getValue()).append((i == whereClauses.size() - 1 ? ".\n" : ";\n"));
        }

        // FILTER Clauses
        if (filterClauses != null && !filterClauses.isEmpty()) {
            query.append("FILTER (");

            i = 0;
            for (Map.Entry<String, String> filterClause : filterClauses.entrySet()) {
                query.append(" ?").append(filterClause.getKey()).append(" = ").append(filterClause.getValue()).append((i++ == filterClauses.size() - 1 ? " )\n" : " && "));
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
