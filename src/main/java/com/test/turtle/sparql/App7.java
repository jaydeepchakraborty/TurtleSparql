package com.test.turtle.sparql;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class App7 {
	public static void main(String[] args) {
		 
        try {
               Model model = ModelFactory.createDefaultModel();
              
               model = model.read(App7.class.getResource("/ex046.ttl").toString());

               Query query = QueryFactory.create(SparqlQuery.queryString7);
               QueryExecution qe = QueryExecutionFactory.create(query, model);

               ResultSet results = qe.execSelect();
               //not working
               while (results.hasNext()) {
                     QuerySolution row = results.next();
                     String value1 = row.getLiteral("doctorFirst").toString();
                     String value2 = row.getLiteral("doctorLast").toString();
                     String value3 = row.getLiteral("spouseFirst").toString();
                     String value4 = row.getLiteral("spouseLast").toString();

                     System.out.println("---------------------");
                     System.out.println(value1);
                     System.out.println(value2);
                     System.out.println(value3);
                     System.out.println(value4);
                     System.out.println("---------------------");
               }
        } catch (Exception e) {
               e.printStackTrace();
        }
 }
}
