package it.polimi.awt.service;

import java.util.List;

import it.polimi.awt.model.*;



public interface PersistenceService {

	public List<Mountains> findAllMountains(); 
	public Mountains findMountainByName(String name) ;
	public void insertMountains (List<Mountains>  mountains);
	public List<Media> findAllMedias(int mountain);
	public void insertMedias (List<Media>  medias, Mountains mountain);
	public List<Media> findSavedMountains();
	
}
