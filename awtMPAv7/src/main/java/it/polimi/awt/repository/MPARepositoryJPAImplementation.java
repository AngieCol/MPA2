package it.polimi.awt.repository;


import it.polimi.awt.model.Media;
import it.polimi.awt.model.Mountains;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;


@Repository
public class MPARepositoryJPAImplementation implements MPARepository  {

	@PersistenceContext
	private EntityManager em;

	
	
	public Mountains findMountainByName(String name) {
		try{
			TypedQuery<Mountains> query = em.createQuery("Select b from Mountains b where b.name='" + name + "'",	Mountains.class);
			return query.getSingleResult();
		}catch(Exception e){
			
			return null;
		}
	}

	public List<Mountains> findAllMountains() {
		List<Mountains> mountains= new ArrayList<Mountains>();
		
		
		TypedQuery<Mountains> query = em.createQuery("Select b from Mountains b",Mountains.class);
		
		mountains=query.getResultList();
		
		return mountains;
		
	}
	
	public void insertMountains (List<Mountains>  mountains){
		for (Mountains mountain : mountains) {
			em.persist(mountain);
			em.close();
		}
	}
	
	
}
