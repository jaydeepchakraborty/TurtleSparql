package com.test.turtle.sparql;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class App6 {
    public static void main(String[] args) {
    	 
        try {
               Model model = ModelFactory.createDefaultModel();
               ;
               model = model.read(App6.class.getResource("/ex012.ttl").toString());

               Query query = QueryFactory.create(SparqlQuery.queryString6);
               QueryExecution qe = QueryExecutionFactory.create(query, model);

               ResultSet results = qe.execSelect();

               while (results.hasNext()) {
                     QuerySolution row = results.next();
                     String value1 = row.getResource("s").toString();
                     String value2 = row.getResource("p").toString();
                     String value3 = row.getLiteral("o").toString();

                     System.out.println("---------------------");
                     System.out.println(value1);
                     System.out.println(value2);
                     System.out.println(value3);
                     System.out.println("---------------------");
               }
        } catch (Exception e) {
               e.printStackTrace();
        }
 }
}
