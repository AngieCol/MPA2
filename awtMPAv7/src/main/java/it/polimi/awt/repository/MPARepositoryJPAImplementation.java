package it.polimi.awt.repository;

import it.polimi.awt.model.Mountains;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


@Repository
public class MPARepositoryJPAImplementation implements MPARepository  {

	@PersistenceContext
	private EntityManager em;

	//@Override
	public List<Mountains> findMountainByName(String name) {
		List<Mountains> mountains= new ArrayList<Mountains>();;
		System.out.println("OJOOOO Metodo ILIO -----------------");
		
		em.find(Mountains.class, 1);
		System.out.println("OJOOOO Metodo ILIO -----------------");
		
		return  new ArrayList<Mountains>() ;
		
	}
	
	
}
