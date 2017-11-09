package com.test.turtle.sparql;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class App2 {

	public static void main(String[] args) {

		try {
			Model model = ModelFactory.createDefaultModel();
			
			model = model.read(App2.class.getResource("/ex002.ttl").toString());

			Query query = QueryFactory.create(SparqlQuery.queryString2);
			QueryExecution qe = QueryExecutionFactory.create(query, model);

			ResultSet results = qe.execSelect();

			while (results.hasNext()) {
				QuerySolution row = results.next();
				String value = row.getResource("x").toString();

				System.out.println("---------------------");
				System.out.println(value);
				System.out.println("---------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
