package it.polimi.awt.service;

import java.util.List;

import it.polimi.awt.model.*;



public interface PersistenceService {

	public List<Mountains> findAll(); 
	public Mountains findMountainByName(String name) ;
	
}
