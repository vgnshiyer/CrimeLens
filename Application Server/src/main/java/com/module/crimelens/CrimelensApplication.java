package com.module.crimelens;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.module.crimelens.Utilities.SparqlQueryUtility;

@SpringBootApplication
public class CrimelensApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrimelensApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

		// testing SparqlQueryUtility
        List<String> selectVariables = Arrays.asList("CrimeEvent", "CrimeID", "Classification", "CrimeDate", "Location", "Victim", "Perpetrator");
		String entity = "CrimeEvent";
		Map<String, String> whereClauses = new HashMap<>();
		whereClauses.put("hasCrimeID", "CrimeID");
		whereClauses.put("hasClassification", "Classification");
		whereClauses.put("hasCrimeDate", "CrimeDate");
		whereClauses.put("hasLocation", "Location");
		whereClauses.put("hasVictim", "Victim");
		whereClauses.put("hasPerpetrator", "Perpetrator");
		
		Map<String, String> filterClauses = new HashMap<>();
		filterClauses.put("CrimeID", "10038624");

		System.out.println(SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, filterClauses, 0));

		System.out.println();

		Map<String, String> data = new HashMap<>();
		data.put("hasCrimeID", "10038624");
		data.put("hasClassification", "Theft");
		data.put("hasCrimeDate", "2021-03-01");
		data.put("hasLocation", "Downtown");
		data.put("hasVictim", "Victim456");
		data.put("hasPerpetrator", "Perpetrator789");

		System.out.println(SparqlQueryUtility.buildInsertQuery(entity,data));
	}

}
