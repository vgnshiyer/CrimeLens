package com.module.crimelens.Utilities;

import javax.management.Query;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.rdf.model.RDFNode;
import org.springframework.stereotype.Service;

import com.module.crimelens.Models.CrimeEvent;
import com.module.crimelens.Models.Location;
import com.module.crimelens.Models.Perpetrator;
import com.module.crimelens.Models.Victim;

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

    public static Perpetrator mapToPerpetrator(QuerySolution querySolution) {
        Perpetrator perpetrator = new Perpetrator();

        RDFNode node = querySolution.get("PerpetratorID");
        if (node != null && node.isLiteral()) {
            perpetrator.setId(node.asLiteral().getInt());
        }

        node = querySolution.get("Race");
        if (node != null && node.isLiteral()) {
            perpetrator.setRace(node.asLiteral().getString());
        }

        node = querySolution.get("Age");
        if (node != null && node.isLiteral()) {
            perpetrator.setAge(node.asLiteral().getString());
        }

        node = querySolution.get("Gender");
        if (node != null && node.isLiteral()) {
            perpetrator.setGender(node.asLiteral().getString());
        }

        return perpetrator;
    }

    public static Victim mapToVictim(QuerySolution querySolution) {
        Victim victim = new Victim();

        RDFNode node = querySolution.get("VictimID");
        if (node != null && node.isLiteral()) {
            victim.setId(node.asLiteral().getInt());
        }

        node = querySolution.get("Race");
        if (node != null && node.isLiteral()) {
            victim.setRace(node.asLiteral().getString());
        }

        node = querySolution.get("Age");
        if (node != null && node.isLiteral()) {
            victim.setAge(node.asLiteral().getString());
        }

        node = querySolution.get("Gender");
        if (node != null && node.isLiteral()) {
            victim.setGender(node.asLiteral().getString());
        }

        return victim;
    }

    public static Location mapToLocation(QuerySolution querySolution) {
        Location location = new Location();

        RDFNode node = querySolution.get("LocationID");
        if (node != null && node.isLiteral()) {
            location.setId(node.asLiteral().getInt());
        }

        node = querySolution.get("Latitude");
        if (node != null && node.isLiteral()) {
            location.setLat(Double.parseDouble(node.asLiteral().getString()));
        }

        node = querySolution.get("Longitude");
        if (node != null && node.isLiteral()) {
            location.setLon(Double.parseDouble(node.asLiteral().getString()));
        }

        node = querySolution.get("City");
        if (node != null && node.isLiteral()) {
            location.setCity(node.asLiteral().getString());
        }

        node = querySolution.get("State");
        if (node != null && node.isLiteral()) {
            location.setState(node.asLiteral().getString());
        }

        node = querySolution.get("Street");
        if (node != null && node.isLiteral()) {
            location.setStreet(node.asLiteral().getString());
        }

        return location;
    }
}
