package com.module.crimelens.Utilities;

public class SparqlQueryUtility {
    
    public static String findAll(String entity) {
        return "SELECT ?s ?p ?o WHERE { ?s a :" + entity + " . ?s ?p ?o . }";
    }

    
}
