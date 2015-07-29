package it.polimi.awt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hp.hpl.jena.query.ParameterizedSparqlString;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFactory;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.ResourceFactory;

@Service
public class DBpediaServiceImplementation implements DBpediaService{

	@Override
	public String isAMountain() {

		List <String> keywords= new ArrayList<String>();


		

		


/*

		ParameterizedSparqlString qs = new ParameterizedSparqlString( "" +
				"prefix rdfs:    <http://www.w3.org/2000/01/rdf-schema#>\n" +
				"\n" +
				"select ?resource where {\n" +
				"  ?resource rdfs:label ?label\n" +
				"}" );

		Literal mountain = ResourceFactory.createLangLiteral( "Mountain", "en" );
		qs.setParam( "label", mountain );

		System.out.println( qs );

		QueryExecution exec = QueryExecutionFactory.sparqlService( "http://dbpedia.org/sparql", qs.asQuery() );


		ResultSet results = ResultSetFactory.copyResults( exec.execSelect() );

		while ( results.hasNext() ) {

			System.out.println( results.next().get( "resource" ));
			System.out.println( results.next()); //ojo ver como coger la info!!!!!
			//System.out.println( results.next().get);
			//https://jena.apache.org/documentation/javadoc/arq/com/hp/hpl/jena/query/ResultSet.html
		}

		ResultSetFormatter.out( results );
*/

		return "yes,45,48";
	} 



}
