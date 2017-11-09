package com.test.turtle.sparql;

public interface SparqlQuery {

	String queryString1 = "PREFIX ab: <http://learningsparql.com/ns/addressbook#> "
			+ "SELECT ?x " + "WHERE " + "{ ab:craig ab:email ?x . }";

	String queryString2 = "PREFIX ab: <http://learningsparql.com/ns/addressbook#> "
			+ "SELECT ?x " + "WHERE " + "{ ?x ab:homeTel '(229) 276-5135' . }";

	String queryString3 = "PREFIX ab: <http://learningsparql.com/ns/addressbook#>"
			+ "SELECT ?propertyName ?propertyValue "
			+ "WHERE "
			+ "{ ab:cindy ?propertyName ?propertyValue . }";

	String queryString4 = "PREFIX ab: <http://learningsparql.com/ns/addressbook#>"
			+ "SELECT ?first ?last "
			+ "WHERE "
			+ "{ "
			+ " ?person ab:homeTel '(229) 276-5135' ."
			+ " ?person ab:firstName ?first ."
			+ " ?person ab:lastName  ?last ." + "}";

	String queryString5 = "PREFIX a: <http://learningsparql.com/ns/addressbook#>"
			+ "SELECT  ?propertyName ?propertyValue "
			+ "WHERE "
			+ "{ "
			+ " ?person a:firstName 'Cindy' ."
			+ " ?person a:lastName  'Marshall' ."
			+ " ?person ?propertyName ?propertyValue ." + "}";

	String queryString6 = "PREFIX ab: <http://learningsparql.com/ns/addressbook#>"
			+ "SELECT * "
			+ "WHERE"
			+ "{"
			+ "?s ?p ?o . "
			+ "FILTER (regex(?o, 'yahoo','i'))" + "}";

	String queryString7 = "PREFIX ab: <http://learningsparql.com/ns/addressbook#>"
			+ "SELECT ?doctorFirst ?doctorLast ?spouseFirst ?spouseLast "
			+ "WHERE "
			+ "{"
			+ "?s ab:firstName 'Cindy' ;"
			+ "ab:lastName 'Marshall' ;"
			+ "ab:doctor ?doctor ;"
			+ "ab:spouse ?spouse .  "
			+

			"?doctor ab:firstName ?doctorFirst ;"
			+ "ab:lastName ?doctorLast ."
			+

			"?spouse ab:firstName ?spouseFirst ;"
			+ "ab:lastName ?spouseLast ."
			+ "}";

	String queryString8 = "PREFIX ab: <http://learningsparql.com/ns/addressbook#>"
			+ "SELECT ?x "
			+ "WHERE "
			+ "{ "
			+ "ab:craig ab:email ?x . "
			+ "FILTER ( lang(?x) = 'fr' )" + "}";

	String queryString9 = "PREFIX ab: <http://learningsparql.com/ns/addressbook#>"
			+ "SELECT ?first ?last ?workTel "
			+ "WHERE "
			+ "{ "
			+ "?s ab:firstName ?first ; "
			+ "ab:lastName ?last ."
			+ "OPTIONAL "
			+ "{ ?s ab:workTel ?workTel . }" + "}";

	String queryString10 = "PREFIX ab: <http://learningsparql.com/ns/addressbook#>"
			+ "SELECT ?first ?last ?workTel ?nick"
			+ "WHERE"
			+ "{"
			+ "?s ab:firstName ?first ;"
			+ "ab:lastName ?last ."
			+ "OPTIONAL { ?s ab:workTel ?workTel . }"
			+ "OPTIONAL { ?s ab:nick ?nick .  }" + "}";

	String queryString11 = "PREFIX ab: <http://learningsparql.com/ns/addressbook#>"
			+ "SELECT ?first ?last "
			+ "WHERE "
			+ "{"
			+ "?s ab:firstName ?first ;"
			+ "ab:lastName ?last ."
			+ "OPTIONAL { ?s ab:workTel ?workNum . }"
			+ "FILTER (!bound(?workNum))" + "}";

	String queryString12 = "PREFIX ab: <http://learningsparql.com/ns/addressbook#>"
			+ "SELECT ?first ?last "
			+ "WHERE "
			+ "{"
			+ "?s ab:firstName ?first ;"
			+ "ab:lastName ?last ."
			+ "OPTIONAL { ?s ab:workTel ?workNum . }"
			+ "FILTER (bound(?workNum))" + "}";

	String queryString13 = "PREFIX ab: <http://learningsparql.com/ns/addressbook#>"
			+ "SELECT ?first ?last "
			+ "WHERE "
			+ "{"
			+ "?s ab:firstName ?first ; "
			+ "ab:lastName ?last . "
			+ "FILTER NOT EXISTS { ?s ab:workTel ?workNum } " + "}";

	String queryString14 = "PREFIX ab: <http://learningsparql.com/ns/addressbook#>"
			+ "SELECT ?first ?last "
			+ "WHERE "
			+ "{"
			+ "?s ab:firstName ?first ; "
			+ "ab:lastName ?last . "
			+ "MINUS { ?s ab:workTel ?workNum } " + "}";

	String queryString15 = "PREFIX ab: <http://learningsparql.com/ns/addressbook#>"
			+ "SELECT ?last ?first ?courseName "
			+ "WHERE"
			+ "{"
			+ "?s ab:firstName ?first ;"
			+ "ab:lastName ?last ;"
			+ "ab:takingCourse ?course . " +

			"?course ab:courseTitle ?courseName ." + "}";

	String queryString16 = "PREFIX : <http://learningsparql.com/ns/papers#>"
			+ "PREFIX c: <http://learningsparql.com/ns/citations#>"
			+ "SELECT ?s" + "WHERE { ?s c:cites+ :paperA . }";

	String queryString17 = "PREFIX ab: <http://learningsparql.com/ns/addressbook#>"
			+ "PREFIX d:  <http://learningsparql.com/ns/data#> "
			+

			"SELECT * "
			+ "WHERE"
			+ "{"
			+ "{ ?person ab:firstName ?first ; ab:lastName ?last . }"
			+ "UNION"
			+ "{ ?course ab:courseTitle ?courseName . }" +

			"}";

	// FILTER (!(isURI(?city)))
	// FILTER (?cost IN (8, 12, 10))
	// FILTER (?cost NOT IN (8, 12, 10))
	String queryString18 = "PREFIX dm: <http://learningsparql.com/ns/demo#>"
			+ "SELECT ?s ?cost " + "WHERE" + "{" + "?s dm:cost ?cost ."
			+ "FILTER (?cost < 10)" + "}";

	String queryString19 = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
			+ "SELECT ?label "
			+ "WHERE"
			+ "{ ?s rdfs:label ?label . }"
			+ "LIMIT 2";

	String queryString20 = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
			+ "SELECT ?label "
			+ "WHERE"
			+ "{ ?s rdfs:label ?label . }"
			+ "OFFSET 3";

	String queryString21 = "PREFIX ab: <http://learningsparql.com/ns/addressbook#>"
			+ "SELECT ?lastName ?courseName "
			+ "WHERE "
			+ "{"
			+ "{"
			+ "SELECT ?lastName "
			+ "WHERE { ?student ab:lastName ?lastName . }"
			+ "}"
			+

			"{"
			+ "SELECT ?courseName "
			+ "WHERE { ?course ab:courseTitle ?courseName . }" + "}" +

			"}";

	// SELECT (UCASE(SUBSTR(?description,1,3))

	String queryString22 = "PREFIX e: <http://learningsparql.com/ns/expenses#>"
			+ "SELECT ?mealCode ?amount " + "WHERE " + "{"
			+ "?meal e:description ?description ;" + "e:amount ?amount ."
			+ "BIND (UCASE(SUBSTR(?description,1,3)) as ?mealCode)" + "}";

}
