package com.test.turtle.sparql;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class App11 {
	public static void main(String[] args) {
		 
        try {
               Model model = ModelFactory.createDefaultModel();
              
               model = model.read(App11.class.getResource("/ex054.ttl").toString());

               /*fetch only those whose does not have workTel(bound)*/
               //Query query = QueryFactory.create(SparqlQuery.queryString11);
               /*fetch only those whose does have workTel(bound)*/
               //Query query = QueryFactory.create(SparqlQuery.queryString12);
               /*fetch only those whose does not have workTel(filter)*/
               //Query query = QueryFactory.create(SparqlQuery.queryString13);
               /*fetch only those whose does not have workTel(MINUS)*/
               Query query = QueryFactory.create(SparqlQuery.queryString14);
              
              
               QueryExecution qe = QueryExecutionFactory.create(query, model);

               ResultSet results = qe.execSelect();
              
               while (results.hasNext()) {
                     QuerySolution row = results.next();
                     String value1 = row.getLiteral("first")!= null?row.getLiteral("first").toString():"NULL";
                     String value2 = row.getLiteral("last")!= null?row.getLiteral("last").toString():"NULL";
                    
                     System.out.println("---------------------");
                     System.out.println(value1);
                     System.out.println(value2);
                     System.out.println("---------------------");
               }
        } catch (Exception e) {
               e.printStackTrace();
        }
 }
}
