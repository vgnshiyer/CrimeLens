package com.module.crimelens;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.module.crimelens.Utilities.SparqlQueryUtility;

@SpringBootApplication
public class CrimelensApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

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
		
		List<String> filterClauses = Arrays.asList("?CrimeID = 10038624");

		System.out.println(SparqlQueryUtility.buildQuery(selectVariables, entity, whereClauses, null, filterClauses, 0));
    }

}
