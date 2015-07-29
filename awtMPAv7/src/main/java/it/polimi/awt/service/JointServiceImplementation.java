package it.polimi.awt.service;

import it.polimi.awt.model.Media;
import it.polimi.awt.model.Mountains;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hp.hpl.jena.query.ParameterizedSparqlString;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFactory;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.ResourceFactory;

@Service
public class JointServiceImplementation implements JointService{
	
	
	
	
	@Autowired
	private FlickrService flickerService;


	@Autowired
	private PanoramioService panoramioService;

	@Autowired
	private DBpediaService DBService;


	@Autowired
	private PersistenceService ps;




	@Autowired
	private GooglePlacesService gs;
	
	
	
	
	

	@Override
	public List<String> foundMountainsForResults(String name)
	{
		
	List<String> modelo= new ArrayList<String>() ;

	return modelo;	
	} 



}
