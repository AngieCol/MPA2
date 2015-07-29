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

	/**
	 * 
	 */
	@Override
	public Mountains findMountainByName(String name) {
		try{
			TypedQuery<Mountains> query = em.createQuery("Select mon from Mountains mon where mon.name='" + name + "'",	Mountains.class);
			return query.getSingleResult();
		}catch(Exception e){
			
			return null;
		}
	}

	
	
	
	/**
	 * 
	 */
	@Override
	public List<Mountains> findAllMountains() {
		List<Mountains> mountains= new ArrayList<Mountains>();
		
		
		TypedQuery<Mountains> query = em.createQuery("Select mon from Mountains mon",Mountains.class);
		
		mountains=query.getResultList();
		
		return mountains;
		
	}
	
	
	
	/**
	 * 
	 */
	@Override
	public void insertMountains (List<Mountains>  mountains){
		for (Mountains mountain : mountains) {
			em.persist(mountain);
			em.close();
		}
	}
	
	
	
	/**
	 * 
	 */
	@Override
	public List<Media> findAllMedias(int mountain){
		List<Media> medias= new ArrayList<Media>();
		
		
		TypedQuery<Media> query = em.createQuery("Select med from Media med where med.mountain.idMountains='" + mountain + "'",Media.class);
		
		medias=query.getResultList();
		
		return medias;
	
	}
	
	
	
	/**
	 * 
	 */
	@Override
	public List<Media> findSavedMountains(){
		List<Media> medias= new ArrayList<Media>();
		
		
		TypedQuery<Media> query = em.createQuery("Select med from Media med group by med.mountain",Media.class);
		
		medias=query.getResultList();
		
		return medias;
	
	}
	
	
	
	/**
	 * 
	 */
	@Override
	public void insertMedias (List<Media>  medias, Mountains mountain){
		
		for (Media media : medias) {
			media.setMountain(mountain);
			
			em.persist(media);
			em.close();
		}
	}
	
}
