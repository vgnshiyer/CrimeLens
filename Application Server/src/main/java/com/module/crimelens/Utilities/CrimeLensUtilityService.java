package com.module.crimelens.Utilities;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.rdf.model.RDFNode;
import org.springframework.stereotype.Service;

import com.module.crimelens.Models.CrimeEvent;

@Service
public class CrimeLensUtilityService {
    
    public static CrimeEvent mapToCrimeEvent(QuerySolution querySolution) {
        CrimeEvent crimeEvent = new CrimeEvent();

        RDFNode node = querySolution.get("CrimeID");
        if (node != null && node.isLiteral()) {
            crimeEvent.setId(node.asLiteral().getInt());
        }

        node = querySolution.get("Classification");
        if (node != null && node.isLiteral()) {
            crimeEvent.setClassification(node.asLiteral().getString());
        }
        
        node = querySolution.get("CrimeDate");
        if (node != null && node.isLiteral()) {
            crimeEvent.setCrimeDate(node.asLiteral().getString());
        }

        node = querySolution.get("Location");
        if (node != null && node.isLiteral()) {
            crimeEvent.setLocationId(node.asLiteral().getInt());
        }

        node = querySolution.get("Victim");
        if (node != null && node.isLiteral()) {
            crimeEvent.setVictimId(node.asLiteral().getInt());
        }

        node = querySolution.get("Perpetrator");
        if (node != null && node.isLiteral()) {
            crimeEvent.setPerpetratorId(node.asLiteral().getInt());
        }

        return crimeEvent;
    }
}
